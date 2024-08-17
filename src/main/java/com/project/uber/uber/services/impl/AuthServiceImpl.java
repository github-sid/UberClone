package com.project.uber.uber.services.impl;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.SignupDto;
import com.project.uber.uber.dto.UserDto;
import com.project.uber.uber.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
