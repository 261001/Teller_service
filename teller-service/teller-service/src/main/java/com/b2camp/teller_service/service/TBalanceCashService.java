package com.b2camp.teller_service.service;

import com.b2camp.teller_service.dto.TBalanceCashRequest;
import com.b2camp.teller_service.dto.TBalanceCashResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TBalanceCashService {
    TBalanceCashResponse createBalanceCash(TBalanceCashRequest balanceCashRequest);
    List<TBalanceCashResponse> readBalanceCash(String balanceCashId);
    TBalanceCashResponse updateBalanceCash(String balanceCashId,TBalanceCashRequest request);
    String deleteBalanceCash(String balanceCashId);
}
