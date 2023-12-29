package com.beniaminoleone.booking.dto;

import com.beniaminoleone.booking.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequestDto {

    @NotBlank
    @NotNull
    private LocalDate reservationDate;

    @NotBlank
    @NotNull
    private LocalTime reservationTime;
    @NotBlank
    @NotNull
    private UserEntity student;
    @NotBlank
    @NotNull
    private UserEntity teacher;

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
