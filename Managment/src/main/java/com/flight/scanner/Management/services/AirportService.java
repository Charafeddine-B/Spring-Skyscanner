package com.flight.scanner.Management.services;

import com.flight.scanner.Management.model.Airport;
import org.springframework.data.domain.Page;

import java.util.List;


public interface AirportService {
    public abstract Page<Airport> getAllAirportsPaged(int pageNum);
    public abstract List<Airport> getAllAirports();
    public abstract Airport getAirportById(Integer airportId);
    public abstract Airport saveAirport(Airport airport);
    public abstract Airport addAirport(Airport airport);
    public abstract boolean deleteAirport(Integer airportId);
}
