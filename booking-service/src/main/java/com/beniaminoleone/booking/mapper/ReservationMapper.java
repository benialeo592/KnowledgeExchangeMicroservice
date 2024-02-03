package com.beniaminoleone.booking.mapper;


import com.beniaminoleone.library.dto.ReservationRequestDto;
import com.beniaminoleone.library.dto.ReservationResponseDto;
import com.beniaminoleone.booking.entity.ReservationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationResponseDto toDto(ReservationEntity reservation);

    ReservationEntity toEntity (ReservationRequestDto requestDto);
}
