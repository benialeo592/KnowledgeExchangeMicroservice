package com.beniaminoleone.availability.repository;

import com.beniaminoleone.availability.entity.AvailabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailabilityRepository extends MongoRepository<AvailabilityEntity, String> {

    @Query("{ 'teacherId' : ?0 }")
    List<AvailabilityEntity> findAllByTeacherId(Long id);

    @Query("{'teacherId' : ?0, 'date' : ?1, 'time' : ?2}")
    Optional<AvailabilityEntity> findByTeacherIdAndDateAndTime(Long id, LocalDate date, LocalTime time);
}
