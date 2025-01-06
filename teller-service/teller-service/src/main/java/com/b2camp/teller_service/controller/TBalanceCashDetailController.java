package com.b2camp.teller_service.controller;

import com.b2camp.teller_service.dto.TBalanceCashDetailRequest;
import com.b2camp.teller_service.dto.TBalanceCashDetailResponse;
import com.b2camp.teller_service.service.TBalanceCashDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t-balance-cash-detail")
public class TBalanceCashDetailController {
    private TBalanceCashDetailController tBalanceCashDetailController;

    @Autowired
    TBalanceCashDetailService tBalanceCashDetailService;

    @PostMapping
    public TBalanceCashDetailResponse createSetor(@RequestBody TBalanceCashDetailRequest tBalanceCashDetailRequest) {
        return tBalanceCashDetailService.createSetor(tBalanceCashDetailRequest);
    }

    @PostMapping("/withdraw")
    public TBalanceCashDetailResponse withdrawCash(@RequestBody TBalanceCashDetailRequest tBalanceCashDetailRequest) {
        return tBalanceCashDetailService.createTarik(tBalanceCashDetailRequest);
    }
}
