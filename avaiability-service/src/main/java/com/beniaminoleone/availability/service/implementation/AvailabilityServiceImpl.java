package com.beniaminoleone.availability.service.implementation;

import com.beniaminoleone.availability.dto.AvailabilityRequestDto;
import com.beniaminoleone.availability.dto.AvailabilityResponseDto;
import com.beniaminoleone.availability.mapper.AvailabilityMapper;
import com.beniaminoleone.availability.repository.AvailabilityRepository;
import com.beniaminoleone.availability.service.inteface.AvailabilityService;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private AvailabilityRepository avRepo;
    private AvailabilityMapper avMapper;

   // private WebClient.Builder webClientBuilder;

    public AvailabilityServiceImpl(AvailabilityRepository avRepo, AvailabilityMapper avMapper){//, WebClient.Builder webClientBuilder){

        this.avRepo = avRepo;
        this.avMapper = avMapper;
       // this.webClientBuilder = webClientBuilder;
    }

    @Override
    public List<AvailabilityResponseDto> getTeacherAvailabilities(Long id){
        List<AvailabilityResponseDto> list = this.avRepo.findAllByTeacherId(id)
                .stream()
                .map(this.avMapper::toDto)
                .toList();
        return list;
    }

    @Override
    public AvailabilityResponseDto createAvailability(AvailabilityRequestDto request) {
//        List<ReservationResponseDto> teacherReservations = webClientBuilder.build().get()
//                .uri("http://booking-service/api/v1/reservations/user/" + request.getTeacherId())
//                .retrieve()
//                .bodyToFlux(ReservationResponseDto.class)
//                .collectList()
//                .block();
//
//        List<ReservationResponseDto> foundreservations = teacherReservations.stream().
//                filter(reservation -> reservation.getTeacher().getId().equals(request.getTeacherId()) && reservation.getReservationDate().equals(request.getDate()) && reservation.getReservationTime().equals(request.getTime()))
//                .toList();
//
//        if(!foundreservations.isEmpty()){
//            throw new RuntimeException("Teacher already has almost one reservation for that day and that time");
//        }
//
//        if(this.avRepo.findByTeacherIdAndDateAndTime(request.getTeacherId(), request.getDate(), request.getTime()).isPresent()){
//            throw new RuntimeException("The availability already exists");
//        }
//        return this.avMapper.toDto(this.avRepo.save(this.avMapper.toEntity(request)));
        return null;
    }

    @Override
    public Boolean deleteAvailability(String availabilityId){
        this.avRepo.delete(this.avRepo.findById(availabilityId).orElseThrow(()-> new RuntimeException("User not Found")));
        return true;
    }
}
