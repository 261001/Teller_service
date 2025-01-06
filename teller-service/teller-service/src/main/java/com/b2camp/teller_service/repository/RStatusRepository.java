package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.RStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RStatusRepository extends JpaRepository<RStatus,String> {
    Optional<RStatus> findByStatusName(String statusName);
}
