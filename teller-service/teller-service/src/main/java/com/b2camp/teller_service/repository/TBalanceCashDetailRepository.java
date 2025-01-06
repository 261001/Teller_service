package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.TBalanceCashDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TBalanceCashDetailRepository extends JpaRepository<TBalanceCashDetail,String> {
}
