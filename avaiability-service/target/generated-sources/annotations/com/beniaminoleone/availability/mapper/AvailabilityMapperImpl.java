package com.beniaminoleone.availability.mapper;

import com.beniaminoleone.availability.entity.AvailabilityEntity;
import com.beniaminoleone.library.dto.AvailabilityRequestDto;
import com.beniaminoleone.library.dto.AvailabilityResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T17:27:46+0100",
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

        availabilityResponseDto.setId( availability.getId() );
        availabilityResponseDto.setDate( availability.getDate() );
        availabilityResponseDto.setTime( availability.getTime() );
        availabilityResponseDto.setGenre( availability.getGenre() );

        return availabilityResponseDto;
    }

    @Override
    public AvailabilityEntity toEntity(AvailabilityRequestDto request) {
        if ( request == null ) {
            return null;
        }

        AvailabilityEntity availabilityEntity = new AvailabilityEntity();

        availabilityEntity.setTeacherId( request.getTeacherId() );
        availabilityEntity.setDate( request.getDate() );
        availabilityEntity.setTime( request.getTime() );
        availabilityEntity.setGenre( request.getGenre() );

        return availabilityEntity;
    }
}
