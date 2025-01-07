package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.TBalanceCashDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TBalanceCashDetailRepository extends JpaRepository<TBalanceCashDetail,String> {
    List<TBalanceCashDetail> findByBalanceCashId(String balanceCashId);
}
