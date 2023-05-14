package com.flight.scanner.Managment.services;

import com.flight.scanner.Managment.model.Airport;
import com.flight.scanner.Managment.model.Plane;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AirportService {
    public abstract Page<Airport> getAllAirportsPaged(int pageNum);
    public abstract List<Airport> getAllAirports();
    public abstract Airport getAirportById(Integer airportId);
    public abstract Airport saveAirport(Airport airport);
    public abstract void deleteAirport(Integer airpportId);
}
