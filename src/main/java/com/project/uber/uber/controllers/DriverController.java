package com.project.uber.uber.controllers;


import com.project.uber.uber.dto.RideDto;
import com.project.uber.uber.dto.RideStartDto;
import com.project.uber.uber.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestID}")
    public ResponseEntity<RideDto> acceptRide(@PathVariable Long rideRequestID){

        return ResponseEntity.ok(driverService.acceptRide(rideRequestID));
    }

    @PostMapping("/startRide/{rideRequestId}")
    public ResponseEntity<RideDto> startRide(@PathVariable Long rideRequestId,
                                             @RequestBody RideStartDto rideStartDto) {
        return ResponseEntity.ok(driverService.startRide(rideRequestId, rideStartDto.getOtp()));
    }



}
