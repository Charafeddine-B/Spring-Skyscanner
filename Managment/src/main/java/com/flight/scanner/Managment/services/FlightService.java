package com.flight.scanner.Managment.services;

import com.flight.scanner.Managment.model.Airport;
import com.flight.scanner.Managment.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface FlightService {
    public abstract Page<Flight> getAllFlightsPaged(int pageNum);
    public abstract List<Flight> getAllFlights();
    public abstract Flight getFlightById(long flightId);
    public abstract Flight saveFlight(Flight flight);
    public abstract void deleteFlightById(long flightId);
    public abstract List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate);

}
