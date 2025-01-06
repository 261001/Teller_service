package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.TSavingAccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TSavingAccountDetailRepository extends JpaRepository<TSavingAccountDetail,String> {
}
