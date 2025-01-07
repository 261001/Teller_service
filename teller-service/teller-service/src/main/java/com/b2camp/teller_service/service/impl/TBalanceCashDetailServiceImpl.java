package com.b2camp.teller_service.service.impl;

import com.b2camp.teller_service.dto.TBalanceCashDetailRequest;
import com.b2camp.teller_service.dto.TBalanceCashDetailResponse;
import com.b2camp.teller_service.entity.TBalanceCash;
import com.b2camp.teller_service.entity.TBalanceCashDetail;
import com.b2camp.teller_service.entity.TSavingAccount;
import com.b2camp.teller_service.enums.Status;
import com.b2camp.teller_service.enums.TransactionType;
import com.b2camp.teller_service.repository.RStatusRepository;
import com.b2camp.teller_service.repository.TBalanceCashDetailRepository;
import com.b2camp.teller_service.repository.TBalanceCashRepository;
import com.b2camp.teller_service.repository.TSavingAccountRepository;
import com.b2camp.teller_service.service.TBalanceCashDetailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TBalanceCashDetailServiceImpl implements TBalanceCashDetailService {

    @Autowired
    TBalanceCashDetailRepository tBalanceCashDetailRepository;

    @Autowired
    TBalanceCashRepository tBalanceCashRepository;

    @Autowired
    TSavingAccountRepository tSavingAccountRepository;

    @Autowired
    RStatusRepository rStatusRepository;

    @Override
    @Transactional
    public TBalanceCashDetailResponse createTarik(TBalanceCashDetailRequest tBalanceCashDetailRequest) {
        TBalanceCash sourceBalance = tBalanceCashRepository
                .findByAccountNumber(tBalanceCashDetailRequest.getDestAccountNumber())
                .orElseThrow(() -> new RuntimeException("AccountNumber TBalanceCash not found"));

        TSavingAccount destSaving = tSavingAccountRepository
                .findByAccountNumber(tBalanceCashDetailRequest.getSavingAccountNumber())
                .orElseThrow(() -> new RuntimeException("AccountNumber TSavingAccount not found"));

        if (tBalanceCashDetailRequest.getNominal()
                .compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Nominal must be greater than zero");
        }

        BigDecimal newSourceBalance = sourceBalance.getBalance()
                .subtract(tBalanceCashDetailRequest.getNominal());
        if (newSourceBalance.compareTo(BigDecimal.ZERO) != 1) {
            throw new RuntimeException("Saldo tidak mencukupi");
        }
        sourceBalance.setBalance(newSourceBalance);
        tBalanceCashRepository.save(sourceBalance);

        BigDecimal newDestBalance = destSaving.getBalance()
                .add(tBalanceCashDetailRequest.getNominal());
        destSaving.setBalance(newDestBalance);
        tSavingAccountRepository.save(destSaving);

        TBalanceCashDetail transaction = TBalanceCashDetail.builder()
                .balanceCashId(sourceBalance.getBalanceCashId())
                .nominal(tBalanceCashDetailRequest.getNominal())
                .mutation(TransactionType.DEBIT.getDescription())
                .destAccountNumber(tBalanceCashDetailRequest.getSavingAccountNumber())
                .endBalance(newSourceBalance)
                .balance(sourceBalance.getBalance())
                .referenceCode(UUID.randomUUID().toString())
                .rStatus(rStatusRepository.getReferenceById(Status.ACTIVE.getKey()))
                .createdAt(Timestamp.from(Instant.now()))
                .build();
        tBalanceCashDetailRepository.save(transaction);

        TBalanceCashDetailResponse response = new TBalanceCashDetailResponse();
        response.setBalanceCashDetailId(transaction.getBalanceCashDetailId());
        response.setBalanceCashId(transaction.getBalanceCashId());
        response.setNominal(transaction.getNominal());
        response.setMutation(transaction.getMutation());
        response.setDestAccountNumber(transaction.getDestAccountNumber());
        response.setEndBalance(transaction.getEndBalance());
        response.setBalance(transaction.getBalance());
        response.setReferenceCode(transaction.getReferenceCode());
        response.setCreatedAt(transaction.getCreatedAt());

        return response;
    }

    @Override
    public List<TBalanceCashDetailResponse> getTransactionHistory(String destAccountNumber) {
        return tBalanceCashDetailRepository.findByBalanceCashId(destAccountNumber)
                .stream()
                .map(t -> TBalanceCashDetailResponse.builder()
                        .balanceCashDetailId(t.getBalanceCashDetailId())
                        .balanceCashId(t.getBalanceCashId())
                        .nominal(t.getNominal())
                        .mutation(t.getMutation())
                        .destAccountNumber(t.getDestAccountNumber())
                        .endBalance(t.getEndBalance())
                        .balance(t.getBalance())
                        .referenceCode(t.getReferenceCode())
                        .createdAt(t.getCreatedAt())
                        .authorizationAt(t.getAuthorizationAt())
                        .build()
                )
                .toList();
    }

    @Override
    @Transactional
    public TBalanceCashDetailResponse createSetor(TBalanceCashDetailRequest tBalanceCashDetailRequest) {
        try {
            TBalanceCash sourceBalance = tBalanceCashRepository.findByAccountNumber(tBalanceCashDetailRequest.getDestAccountNumber())
                    .orElseThrow(() -> new RuntimeException("AccountNumber TBalanceCash not found"));

            TSavingAccount sourceSaving = tSavingAccountRepository.findByAccountNumber(tBalanceCashDetailRequest.getSavingAccountNumber())
                    .orElseThrow(() -> new RuntimeException("AccountNumber TSavingAccount not found"));

            if (tBalanceCashDetailRequest.getNominal().compareTo(BigDecimal.ZERO) <= 0) {
                throw new RuntimeException("Nominal harus lebih besar dari nol");
            }

            BigDecimal newSavingBalance = sourceSaving.getBalance()
                    .subtract(tBalanceCashDetailRequest.getNominal());
            if (newSavingBalance.compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("Saldo tidak mencukupi di TSavingAccount");
            }
            sourceSaving.setBalance(newSavingBalance);
            tSavingAccountRepository.save(sourceSaving);

            BigDecimal newSourceBalance = sourceBalance.getBalance().add(tBalanceCashDetailRequest.getNominal());
            sourceBalance.setBalance(newSourceBalance);
            tBalanceCashRepository.save(sourceBalance);

            TBalanceCashDetail transaction = TBalanceCashDetail.builder()
                    .balanceCashId(sourceBalance.getBalanceCashId())
                    .nominal(tBalanceCashDetailRequest.getNominal())
                    .mutation(TransactionType.CREDIT.getDescription())
                    .destAccountNumber(tBalanceCashDetailRequest.getSavingAccountNumber())
                    .endBalance(newSourceBalance)
                    .balance(sourceBalance.getBalance())
                    .referenceCode(UUID.randomUUID().toString())
                    .rStatus(rStatusRepository.getReferenceById(Status.ACTIVE.getKey()))
                    .createdAt(Timestamp.from(Instant.now()))
                    .build();
            tBalanceCashDetailRepository.save(transaction);

            TBalanceCashDetailResponse response = new TBalanceCashDetailResponse();
            response.setBalanceCashDetailId(transaction.getBalanceCashDetailId());
            response.setBalanceCashId(transaction.getBalanceCashId());
            response.setNominal(transaction.getNominal());
            response.setMutation(transaction.getMutation());
            response.setDestAccountNumber(transaction.getDestAccountNumber());
            response.setEndBalance(transaction.getEndBalance());
            response.setBalance(transaction.getBalance());
            response.setReferenceCode(transaction.getReferenceCode());
            response.setCreatedAt(transaction.getCreatedAt());

            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException("Terjadi kesalahan saat transaksi");
        }
    }
}
