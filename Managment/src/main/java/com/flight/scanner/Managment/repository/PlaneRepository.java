package com.flight.scanner.Managment.repository;

import com.flight.scanner.Managment.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository  extends JpaRepository<Plane,Long> {
}
