package com.org.CarManagementSystem.repository;

import com.org.CarManagementSystem.model.Car;
import com.org.CarManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Fetch cars by user
    List<Car> findByUser(User user);

    // Search cars by title or description (case-insensitive search)
    List<Car> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    // No need for searchByKeyword method anymore
}
