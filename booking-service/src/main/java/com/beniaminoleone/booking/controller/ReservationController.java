package com.beniaminoleone.booking.controller;

import com.beniaminoleone.booking.dto.ReservationRequestDto;
import com.beniaminoleone.booking.dto.ReservationResponseDto;
import com.beniaminoleone.booking.service.inteface.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationResponseDto>> getAllReservations(){
       return ResponseEntity.ok().body(this.reservationService.getAllReservations());
    }

    @GetMapping("/reservation/{reservationCode}")
    public ResponseEntity<ReservationResponseDto> getReservationByCode(@PathVariable String reservationCode){
        return ResponseEntity.ok().body(this.reservationService.getReservationByCode(reservationCode));
    }

    @GetMapping("/reservations/user/{userId}")
    public ResponseEntity<List<ReservationResponseDto>> getUserReservations(@PathVariable Long userId){
        return ResponseEntity.ok().body(this.reservationService.getUserReservations(userId));
    }

    @GetMapping("/reservations/role/{roleName}")
    public ResponseEntity<List<ReservationResponseDto>> getRoleReservations(@PathVariable String roleName){
        return ResponseEntity.ok().body(this.reservationService.getRoleReservations(roleName));
    }

    @GetMapping("/reservations/date/{date}")
    public ResponseEntity<List<ReservationResponseDto>> getDailyReservations(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return ResponseEntity.ok().body(this.reservationService.getDailyReservations(date));
    }

    @GetMapping("/reservations/user/{userId}/date/{date}")
    public ResponseEntity<List<ReservationResponseDto>> getUserDailyReservations(@PathVariable Long userId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate date){
        return ResponseEntity.ok().body(this.reservationService.getUserDailyReservations(userId, date));
    }

    @PostMapping("/reservation")
    public ResponseEntity<ReservationResponseDto> createReservation(@RequestBody ReservationRequestDto reservationRequest){
        return ResponseEntity.ok().body(this.reservationService.createReservation(reservationRequest));
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Boolean> destroyReservation(@PathVariable Long id){
        return ResponseEntity.ok().body(this.reservationService.destroyReservation(id));
    }




}
