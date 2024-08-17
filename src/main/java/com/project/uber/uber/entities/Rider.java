package com.project.uber.uber.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //Each Rider will have only one user
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

}
