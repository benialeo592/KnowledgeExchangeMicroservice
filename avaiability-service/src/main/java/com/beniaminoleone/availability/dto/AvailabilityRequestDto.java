package com.beniaminoleone.availability.dto;

import com.mongodb.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvailabilityRequestDto {

    private Long teacherId;
    private LocalDate date;
    private LocalTime time;
    private String genre;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
