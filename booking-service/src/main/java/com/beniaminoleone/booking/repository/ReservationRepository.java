package com.beniaminoleone.booking.repository;

import com.beniaminoleone.booking.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Query("SELECT r FROM ReservationEntity r where r.reservationCode = :reservationCode")
    Optional<ReservationEntity> findByReservationCode(@Param("reservationCode") String reservationCode);

    @Query("SELECT r FROM ReservationEntity r where r.student.id = :userId")
    List<ReservationEntity> findByUserId(@Param("userId") Long id);

    @Query("SELECT r FROM ReservationEntity r " +
            "JOIN UserEntity u ON r.student.id = u.id " +
            "JOIN RoleEntity role ON u.role.id = role.id " +
            "WHERE role.name = :roleName")
    List<ReservationEntity> findAllReservationsByUserRole(@Param("roleName") String roleName);

    @Query("SELECT r FROM ReservationEntity r WHERE r.reservationDate = :reservationDate")
    List<ReservationEntity> findAllByDate(@Param("reservationDate") LocalDate reservationDate );

    @Query("SELECT r FROM ReservationEntity r WHERE r.reservationDate = :reservationDate AND r.student.id = :userId")
    List<ReservationEntity> findAllUserReservationsOnDate(@Param("reservationDate") LocalDate reservationDate, @Param("userId") Long userId);

}
