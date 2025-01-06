package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.TSavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TSavingAccountRepository extends JpaRepository<TSavingAccount, String> {

    @Query(value = "SELECT * FROM t_saving_account WHERE account_number = :accountNumber", nativeQuery = true)
    Optional<TSavingAccount> findByAccountNumber(String accountNumber);
}
