package com.project.uber.uber.strategies;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.entities.RideRequest;


public interface RideFareCalculationStrategy {


    double RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);
}
