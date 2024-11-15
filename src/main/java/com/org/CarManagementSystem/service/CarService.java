package com.org.CarManagementSystem.service;

import com.org.CarManagementSystem.model.Car;
import com.org.CarManagementSystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Create a new car
    public Car createCar(String title, String description, List<String> tags, List<MultipartFile> images) {
        Car car = new Car();
        car.setTitle(title);
        car.setDescription(description);
        car.setTags(tags);

        // Simulate image upload and save the image URL (you can replace with real image handling logic)
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile image : images) {
            try {
                imageUrls.add("D://CarManagementSystem/download.jpeg" + image.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        car.setImageUrls(imageUrls);

        // Save the car to the repository
        return carRepository.save(car);
    }

    // Get all cars for a user
    public List<Car> getAllCarsForUser() {
        return carRepository.findAll(); // Fetch all cars
    }

    // Get a specific car by ID
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    // Update an existing car's details
    public Car updateCar(Long id, String title, String description, Set<String> tags, List<MultipartFile> images) {
        Car car = carRepository.findById(id).orElse(null);
        if (car == null) {
            return null; // Car not found
        }

        car.setTitle(title);
        car.setDescription(description);
        car.setTags(new ArrayList<>(tags));

        // Handle image updates (similar to the creation)
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile image : images) {
            try {
                imageUrls.add("http://example.com/images/" + image.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        car.setImageUrls(imageUrls);

        // Save the updated car
        return carRepository.save(car);
    }

    // Delete a car by ID
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    // Search cars by a keyword (e.g., title or description)
    public List<Car> searchCars(String keyword) {
        // Using the repository method to search cars by title or description
        return carRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }
}
