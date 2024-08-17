package com.project.uber.uber.dto;


import com.project.uber.uber.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {



    private UserDto user;
    private Double rating;
}
