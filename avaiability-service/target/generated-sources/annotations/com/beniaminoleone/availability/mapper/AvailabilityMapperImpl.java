package com.beniaminoleone.availability.mapper;

import com.beniaminoleone.availability.entity.AvailabilityEntity;
import com.beniaminoleone.library.dto.AvailabilityRequestDto;
import com.beniaminoleone.library.dto.AvailabilityResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T12:18:47+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AvailabilityMapperImpl implements AvailabilityMapper {

    @Override
    public AvailabilityResponseDto toDto(AvailabilityEntity availability) {
        if ( availability == null ) {
            return null;
        }

        AvailabilityResponseDto availabilityResponseDto = new AvailabilityResponseDto();

        return availabilityResponseDto;
    }

    @Override
    public AvailabilityEntity toEntity(AvailabilityRequestDto request) {
        if ( request == null ) {
            return null;
        }

        AvailabilityEntity availabilityEntity = new AvailabilityEntity();

        return availabilityEntity;
    }
}
