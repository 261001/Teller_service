package com.b2camp.teller_service.service;

import com.b2camp.teller_service.dto.TBalanceCashDetailRequest;
import com.b2camp.teller_service.dto.TBalanceCashDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TBalanceCashDetailService {
    TBalanceCashDetailResponse createSetor(TBalanceCashDetailRequest tBalanceCashDetailRequestRequest);
    TBalanceCashDetailResponse createTarik(TBalanceCashDetailRequest tBalanceCashDetailRequestRequest);
    List<TBalanceCashDetailResponse> getTransactionHistory(String balanceAccountNumber);

}
