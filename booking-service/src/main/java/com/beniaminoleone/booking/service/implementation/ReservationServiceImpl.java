package com.beniaminoleone.booking.service.implementation;

import com.beniaminoleone.booking.client.AvailabilityClient;
import com.beniaminoleone.library.dto.ReservationRequestDto;
import com.beniaminoleone.library.dto.ReservationResponseDto;
import com.beniaminoleone.booking.entity.ReservationEntity;
import com.beniaminoleone.booking.mapper.ReservationMapper;
import com.beniaminoleone.booking.repository.ReservationRepository;
import com.beniaminoleone.booking.service.inteface.ReservationService;
import com.beniaminoleone.library.dto.AvailabilityResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepo;

    private final ReservationMapper reservationMapper;

    private final WebClient.Builder webClientBuilder;

    private final AvailabilityClient availabilityClient;

    public ReservationServiceImpl(ReservationRepository reservationRepo, ReservationMapper reservationMapper, WebClient.Builder webClient, AvailabilityClient availabilityClient){
        this.reservationRepo = reservationRepo;
        this.reservationMapper = reservationMapper;
        this.webClientBuilder = webClient;
        this.availabilityClient = availabilityClient;
    }
    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getAllReservations() {
        return this.reservationRepo.findAll()
                .stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ReservationResponseDto getReservationByCode(String reservationCode) {
        return this.reservationMapper.toDto(this.reservationRepo.findByReservationCode(reservationCode).orElseThrow(()->new RuntimeException("Reservation Not Found")));
    }

    @Override
    @Transactional(readOnly = true)
    public  ReservationResponseDto getReservationById(Long id){
        return this.reservationMapper.toDto(this.reservationRepo.findById(id).orElseThrow(()->new RuntimeException("Reservation Not Found")));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getUserReservations(Long userId) {
        return this.reservationRepo.findByUserId(userId)
                .stream()
                .map(this.reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getRoleReservations(String roleName) {
        return this.reservationRepo.findAllReservationsByUserRole(roleName)
                .stream()
                .map(this.reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getDailyReservations(LocalDate date) {
        return this.reservationRepo.findAllByDate(date)
                .stream()
                .map(this.reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getUserDailyReservations(Long userId, LocalDate date) {
        return this.reservationRepo.findAllUserReservationsOnDate(date, userId)
                .stream()
                .map(this.reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDto createReservation(ReservationRequestDto reservationRequest) {
        ResponseEntity<Object> response = availabilityClient.getAvailability(reservationRequest.getTeacher().getId());


        List<AvailabilityResponseDto> availabilities = webClientBuilder.build().get()
               .uri("http://availability-service/api/v1/availability/" + reservationRequest.getTeacher().getId().toString())
              .retrieve()
                .bodyToFlux(AvailabilityResponseDto.class)
              .collectList()
              .block();

        AvailabilityResponseDto foundAvailability = availabilities.stream()
                .filter(e-> e.getTime().equals(reservationRequest.getReservationTime()) && e.getDate().equals(reservationRequest.getReservationDate()))
                .findFirst()
               .orElseThrow(()-> new RuntimeException("Availability not found"));

       ReservationEntity reservation = this.reservationMapper.toEntity(reservationRequest);
       reservation.setReservationCode(this.generateReservationCode());

      Boolean isDeletedFromService = webClientBuilder.build().delete()
              .uri("http://availability-service/api/v1/availability/" + foundAvailability.getId())
              .retrieve()
              .bodyToMono(Boolean.class)
              .block();

        if(isDeletedFromService == null || !isDeletedFromService){
           throw new RuntimeException("Something wrong...");
        }

        return this.reservationMapper.toDto(this.reservationRepo.save(reservation));

    }

    @Override
    public Boolean destroyReservation(Long reservationId) {
        this.reservationRepo.delete(this.reservationRepo.findById(reservationId).orElseThrow(()->new RuntimeException("Reservation not found")));
        return true;
    }

    private synchronized String generateReservationCode() {
        //provvisiorio
        boolean empty;
        String tmpCode;
        do {
            tmpCode = UUID.randomUUID().toString();
            empty = this.reservationRepo.findByReservationCode(tmpCode).isEmpty();
        } while (!empty);
        return tmpCode;
    }
}
