package com.flight.scanner.Managment.repository;

import com.flight.scanner.Managment.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
