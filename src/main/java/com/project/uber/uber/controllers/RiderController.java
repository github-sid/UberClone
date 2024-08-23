package com.project.uber.uber.controllers;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestDto(@RequestBody RideRequestDto rideRequestDto){

        return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }
}