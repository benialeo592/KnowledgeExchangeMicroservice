package com.beniaminoleone.booking.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate reservationDate;

    @Column(nullable = false)
    private LocalTime reservationTime;
    @Column(nullable = false, updatable = false, unique = true)
    private String reservationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private UserEntity student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", nullable = false)
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
