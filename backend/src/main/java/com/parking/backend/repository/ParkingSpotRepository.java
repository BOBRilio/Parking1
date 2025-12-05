package com.parking.backend.repository;

import com.parking.backend.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    ParkingSpot findByNumber(String number);
}
