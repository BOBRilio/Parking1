package com.parking.backend.repository;

import com.parking.backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByLicensePlate(String licensePlate);
}
