package com.beniaminoleone.library.dto;

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
    private UserModel student;
    @NotBlank
    @NotNull
    private UserModel teacher;

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

    public UserModel getStudent() {
        return student;
    }

    public void setStudent(UserModel student) {
        this.student = student;
    }

    public UserModel getTeacher() {
        return teacher;
    }

    public void setTeacher(UserModel teacher) {
        this.teacher = teacher;
    }
}
