package com.beniaminoleone.availability.mapper;

import com.beniaminoleone.availability.dto.AvailabilityRequestDto;
import com.beniaminoleone.availability.dto.AvailabilityResponseDto;
import com.beniaminoleone.availability.entity.AvailabilityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {

    AvailabilityResponseDto toDto(AvailabilityEntity availability);

    AvailabilityEntity toEntity(AvailabilityRequestDto request);
}
