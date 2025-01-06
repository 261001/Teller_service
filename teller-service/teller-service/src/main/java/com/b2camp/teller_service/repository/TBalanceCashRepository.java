package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.TBalanceCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TBalanceCashRepository extends JpaRepository<TBalanceCash, String> {

    @Query(value = "select * from t_balance_cash tbc where account_number =:accountNumber", nativeQuery = true)
    Optional<TBalanceCash> findByAccountNumber(String accountNumber);
}
