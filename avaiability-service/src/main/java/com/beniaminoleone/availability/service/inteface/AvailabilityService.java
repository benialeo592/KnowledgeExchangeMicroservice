package com.beniaminoleone.availability.service.inteface;

import com.beniaminoleone.availability.dto.AvailabilityRequestDto;
import com.beniaminoleone.availability.dto.AvailabilityResponseDto;

import java.util.List;

public interface AvailabilityService {

    List<AvailabilityResponseDto> getTeacherAvailabilities(Long id);

    AvailabilityResponseDto createAvailability(AvailabilityRequestDto request);

    Boolean deleteAvailability(String availiabilityId);
}
