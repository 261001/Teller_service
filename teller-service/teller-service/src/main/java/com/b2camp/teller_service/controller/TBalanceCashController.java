package com.b2camp.teller_service.controller;

import com.b2camp.teller_service.dto.TBalanceCashRequest;
import com.b2camp.teller_service.dto.TBalanceCashResponse;
import com.b2camp.teller_service.service.TBalanceCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/t-balance-cash")
public class TBalanceCashController {
    private TBalanceCashController tBalanceCashController;
    @Autowired
    TBalanceCashService tBalanceCashService;

    @PostMapping
    public TBalanceCashResponse create(@RequestBody TBalanceCashRequest balanceCashRequest) {
        return tBalanceCashService.createBalanceCash(balanceCashRequest);
    }

    @GetMapping
    public List<TBalanceCashResponse> read(@RequestParam(value = "balanceCashId", required = false) String balanceCashId) {
        return tBalanceCashService.readBalanceCash(balanceCashId);
    }

    @PutMapping("/update/{balanceCashId}")
    public TBalanceCashResponse updated(@PathVariable String balanceCashId,
                                        @RequestBody TBalanceCashRequest request) {
        return tBalanceCashService.updateBalanceCash(balanceCashId, request);
    }

    @DeleteMapping("/delete/{balanceCashId}")
    public String delete(@PathVariable String balanceCashId) {
        return tBalanceCashService.deleteBalanceCash(balanceCashId);
    }
}
