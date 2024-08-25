package com.project.uber.uber.services.impl;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.RideDto;
import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.dto.RiderDto;
import com.project.uber.uber.entities.Driver;
import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.entities.Rider;
import com.project.uber.uber.entities.User;
import com.project.uber.uber.entities.enums.RideRequestStatus;
import com.project.uber.uber.exceptions.ResourceNotFoundException;
import com.project.uber.uber.repositories.RideRequestRepository;
import com.project.uber.uber.repositories.RiderRepository;
import com.project.uber.uber.services.RiderService;
import com.project.uber.uber.strategies.DriverMatchingStrategy;
import com.project.uber.uber.strategies.RideFareCalculationStrategy;
import com.project.uber.uber.strategies.RideStrategyManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideStrategyManager rideStrategyManager;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {


        Rider rider = getCurrentRider();
        //Map the rideRequest with RideRequestDTO
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        //Change the status to Pending
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);
        //Fare Calculation
        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);

        //Set it to the entity
        rideRequest.setFare(fare);

        //Save
        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        //Look for the driver
        List<Driver> drivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

        //Todo : Notification to all the drivers

        //Map and return
        return modelMapper.map(savedRideRequest,RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return null;
    }

    @Override
    public Rider createNewRider(User user) {

        Rider rider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {

        //TODO : implement Spring Security

        return riderRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException("" +
                "Rider not found with id "+1));

    }
}
