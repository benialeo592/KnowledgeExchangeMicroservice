package com.beniaminoleone.booking.repository;

import com.beniaminoleone.booking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.role.id = :roleId")
    List<UserEntity> findAllByRole(@Param("roleId") Long roleId);

}
