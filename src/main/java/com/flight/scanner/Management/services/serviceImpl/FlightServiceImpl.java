package com.flight.scanner.Management.services.serviceImpl;

import com.flight.scanner.Management.model.Airport;
import com.flight.scanner.Management.model.Flight;
import com.flight.scanner.Management.repository.FlightRepository;
import com.flight.scanner.Management.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    public FlightRepository flightRepository;

    @Override
    public Page<Flight> getAllFlightsPaged(int pageNum) {
        return flightRepository.findAll(PageRequest.of(pageNum,5, Sort.by("departureAirport")));

    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();

    }

    @Override
    public Flight getFlightById(long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlightById(long flightId) {
        flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate) {
        return flightRepository.findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals(depAirport, destAirport, depDate);

    }
}
