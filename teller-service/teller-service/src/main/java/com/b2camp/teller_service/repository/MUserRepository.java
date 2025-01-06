package com.b2camp.teller_service.repository;

import com.b2camp.teller_service.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MUserRepository extends JpaRepository<MUser, String> {
    @Query("SELECT u FROM MUser u WHERE (:userName = '' OR :userName IS NULL OR LOWER(u.userName) LIKE LOWER(CONCAT('%', :userName, '%'))) AND u.isDeleted = false")
    List<MUser> findAllByUserNameIgnoreCaseAndIsDeletedIsFalse(@Param("userName") String userName);


    Optional<MUser> findByUserId(String userId);
}
