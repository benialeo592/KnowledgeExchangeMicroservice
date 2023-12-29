package com.beniaminoleone.availability.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.*;

@Document(value = "availability")
public class AvailabilityEntity {

    @Id
    private String id;
    private Long teacherId;
    private LocalDate date;
    private LocalTime time;

    private String genre;

    public AvailabilityEntity() {
    }

    public AvailabilityEntity(String id, Long teacherId, LocalDate date, LocalTime time, String genre) {
        this.id = id;
        this.teacherId = teacherId;
        this.date = date;
        this.time = time;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
