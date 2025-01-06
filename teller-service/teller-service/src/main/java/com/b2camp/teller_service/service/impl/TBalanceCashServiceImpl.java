package com.b2camp.teller_service.service.impl;

import com.b2camp.teller_service.dto.TBalanceCashRequest;
import com.b2camp.teller_service.dto.TBalanceCashResponse;
import com.b2camp.teller_service.entity.TBalanceCash;
import com.b2camp.teller_service.enums.Status;
import com.b2camp.teller_service.repository.RStatusRepository;
import com.b2camp.teller_service.repository.TBalanceCashRepository;
import com.b2camp.teller_service.service.TBalanceCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TBalanceCashServiceImpl implements TBalanceCashService {

    @Autowired
    TBalanceCashRepository tbalanceCashRepository;

    @Autowired
    RStatusRepository rStatusRepository;

    @Override
    public TBalanceCashResponse createBalanceCash(TBalanceCashRequest tBalanceCashRequest) {
        TBalanceCash tBalanceCash = TBalanceCash.builder()
                .accountNumber(tBalanceCashRequest.getAccountNumber())
                .balance(tBalanceCashRequest.getBalance())
                .createdAt(Timestamp.from(Instant.now()))
                .rStatus(rStatusRepository.getReferenceById(Status.ACTIVE.getKey()))
                .isDeleted(false)
                .build();
        if (tBalanceCash.getAccountNumber().length() != 6)
            throw new RuntimeException("AccountNumber must 6 character!");
        tbalanceCashRepository.save(tBalanceCash);
        return buildResponseCreate(tBalanceCash);
    }

    @Override
    public List<TBalanceCashResponse> readBalanceCash(String balanceCashId) {
        List<TBalanceCash> tBalanceCashes = tbalanceCashRepository.findAll();
        List<TBalanceCashResponse> tBalanceCashResponses = tBalanceCashes.stream()
                .map(data -> buildResponseGet(data)).collect(Collectors.toList());
        return tBalanceCashResponses;
    }

    @Override
    public TBalanceCashResponse updateBalanceCash(String balanceCashId, TBalanceCashRequest request) {
        TBalanceCash tBalanceCash = tbalanceCashRepository.findById(balanceCashId)
                .orElseThrow(() -> new RuntimeException("balanceCashId not found"));
        buildEntityUpdate(tBalanceCash, request);
        tbalanceCashRepository.save(tBalanceCash);
        return buildResponseUpdate(tBalanceCash);
    }

    @Override
    public String deleteBalanceCash(String balanceCashId) {
        TBalanceCash tBalanceCash = tbalanceCashRepository.findById(balanceCashId)
                .orElseThrow(() -> new RuntimeException("Account number not found"));
        tBalanceCash.setDeleted(true);
        tbalanceCashRepository.save(tBalanceCash);
        return "Success deleted by balanceCashId : " + tBalanceCash.getAccountNumber();
    }

    private TBalanceCashResponse buildResponseCreate(TBalanceCash tBalanceCash) {
        TBalanceCashResponse tBalanceCashResponse = TBalanceCashResponse.builder()
                .balanceCashId(tBalanceCash.getBalanceCashId())
                .accountNumber(tBalanceCash.getAccountNumber())
                .balance(tBalanceCash.getBalance())
                .statusId(tBalanceCash.getBalanceCashId())
                .createdAt(tBalanceCash.getCreatedAt())
                .isDeleted(tBalanceCash.isDeleted())
                .build();
        return tBalanceCashResponse;
    }

    private TBalanceCashResponse buildResponseGet(TBalanceCash tBalanceCash) {
        TBalanceCashResponse response = TBalanceCashResponse.builder()
                .balanceCashId(tBalanceCash.getBalanceCashId())
                .accountNumber(tBalanceCash.getAccountNumber())
                .balance(tBalanceCash.getBalance())
                .statusId(tBalanceCash.getBalanceCashId())
                .createdAt(tBalanceCash.getCreatedAt())
                .isDeleted(tBalanceCash.isDeleted())
                .build();
        return response;
    }

    private TBalanceCashResponse buildResponseUpdate(TBalanceCash tBalanceCash) {
        TBalanceCashResponse balanceCashResponse = TBalanceCashResponse.builder()
                .balanceCashId(tBalanceCash.getBalanceCashId())
                .accountNumber(tBalanceCash.getAccountNumber())
                .balance(tBalanceCash.getBalance())
                .statusId(tBalanceCash.getBalanceCashId())
                .createdAt(tBalanceCash.getCreatedAt())
                .isDeleted(tBalanceCash.isDeleted())
                .build();
        return balanceCashResponse;
    }

    private void buildEntityUpdate(TBalanceCash tBalanceCash, TBalanceCashRequest request) {
        tBalanceCash.setAccountNumber(request.getAccountNumber());
        tBalanceCash.setBalance(request.getBalance());

    }
}

