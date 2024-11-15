package com.org.CarManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // URL of the image
    private String fileName; // File name or any other metadata if needed

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
