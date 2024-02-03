package com.beniaminoleone.booking.service.inteface;

import com.beniaminoleone.library.dto.ReservationRequestDto;
import com.beniaminoleone.library.dto.ReservationResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<ReservationResponseDto> getAllReservations();
    ReservationResponseDto getReservationByCode(String reservationCode);
    ReservationResponseDto getReservationById(Long id);

    List<ReservationResponseDto> getUserReservations(Long userId);
    List<ReservationResponseDto> getRoleReservations(String roleName);

    List<ReservationResponseDto> getDailyReservations(LocalDate date);

    List<ReservationResponseDto> getUserDailyReservations(Long userId, LocalDate date);

    ReservationResponseDto createReservation(ReservationRequestDto reservationRequest);

    Boolean destroyReservation(Long reservationId);
}
