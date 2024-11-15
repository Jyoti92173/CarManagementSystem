package com.org.CarManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String carType;
    private String company;
    private String dealer;

    @ElementCollection
    private List<String> tags; // car_type, company, etc.

    @ElementCollection
    private List<String> imageUrls; // List of image URLs associated with the car

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Link to the User entity (foreign key)
}
