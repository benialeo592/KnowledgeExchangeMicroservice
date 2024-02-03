package com.beniaminoleone.availability.mapper;

import com.beniaminoleone.availability.entity.AvailabilityEntity;


import com.beniaminoleone.library.dto.AvailabilityRequestDto;
import com.beniaminoleone.library.dto.AvailabilityResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {

    AvailabilityResponseDto toDto(AvailabilityEntity availability);

    AvailabilityEntity toEntity(AvailabilityRequestDto request);
}
