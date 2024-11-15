package com.org.CarManagementSystem.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class carDTO {
    private String title;
    private String description;
    private List<String> tags;
    private List<String> images;
}
