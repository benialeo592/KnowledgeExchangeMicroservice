package com.beniaminoleone.availability.controller;


import com.beniaminoleone.availability.service.inteface.AvailabilityService;
import com.beniaminoleone.library.dto.AvailabilityRequestDto;
import com.beniaminoleone.library.dto.AvailabilityResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AvailabilityController {
    private AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService){
        this.availabilityService = availabilityService;
    }

    @GetMapping("/availability/{teacherId}")
    public ResponseEntity<List<AvailabilityResponseDto>> getTeacherAvailabilities(@PathVariable Long teacherId){
        return ResponseEntity.ok().body(this.availabilityService.getTeacherAvailabilities(teacherId));
    }

    @PostMapping("/availability")
    public ResponseEntity<AvailabilityResponseDto> createTeacherAvailability(@RequestBody AvailabilityRequestDto requestDto){
        return ResponseEntity.ok().body(this.availabilityService.createAvailability(requestDto));
    }

    @DeleteMapping("/availability/{availabilityId}")
    public ResponseEntity<Boolean> destroyTeacherAvailability(@PathVariable String availabilityId){
        return ResponseEntity.ok().body(this.availabilityService.deleteAvailability(availabilityId));
    }



}
