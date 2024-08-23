package com.project.uber.uber.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class Driver {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //Each Rider will have only one user
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

    private Boolean available;

    private String vehicleId;

    @Column(columnDefinition = "geometry(Point, 4326)")
    Point currentLocation;




}
