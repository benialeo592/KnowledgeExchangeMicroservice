package com.beniaminoleone.booking.dto;

import com.beniaminoleone.booking.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ReservationResponseDto {

    private Long id;
    private LocalDate reservationDate;

    private LocalTime reservationTime;
    private String reservationCode;
    @JsonIgnore
    private UserEntity student;

    private UserEntity teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public UserEntity getStudent() {
        return student;
    }

    public void setStudent(UserEntity student) {
        this.student = student;
    }

    public UserEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(UserEntity teacher) {
        this.teacher = teacher;
    }
}
