package com.org.CarManagementSystem.controller;

import com.org.CarManagementSystem.model.Car;
import com.org.CarManagementSystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Create a new car (POST method, expecting JSON or Form data)
    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestParam String title,
                                         @RequestParam String description,
                                         @RequestParam List<String> tags,
                                         @RequestParam List<MultipartFile> images) {
        Car car = carService.createCar(title, description, tags, images);
        return new ResponseEntity<>(car, HttpStatus.CREATED); // Return the created car with HTTP 201
    }

    // List all cars for the user (GET method)
    @GetMapping("/listcars/public")
    public ResponseEntity<List<Car>> listCars() {
        List<Car> cars = carService.getAllCarsForUser();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    // View details of a specific car (GET method)
    @GetMapping("/{id}")
    public ResponseEntity<Car> viewCar(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    // Update a car's details (PUT method, expecting JSON or Form data)
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id,
                                         @RequestParam String title,
                                         @RequestParam String description,
                                         @RequestParam Set<String> tags,
                                         @RequestParam List<MultipartFile> images) {
        Car updatedCar = carService.updateCar(id, title, description, tags, images);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    // Delete a car (DELETE method)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return HTTP 204 No Content
    }

    // Search cars by keyword (GET method)
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam String keyword) {
        List<Car> cars = carService.searchCars(keyword);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
