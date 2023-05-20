package com.flight.scanner.Management.services.serviceImpl;

import com.flight.scanner.Management.model.Airport;
import com.flight.scanner.Management.repository.AirportRepository;
import com.flight.scanner.Management.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    public AirportRepository airportRepository;
    @Override
    public Page<Airport> getAllAirportsPaged(int pageNum) {
        return airportRepository.findAll(PageRequest.of(pageNum,5, Sort.by("airportName")));
    }


    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(Integer airportId) {
        return airportRepository.findById(airportId).orElse(null);
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public boolean deleteAirport(Integer airpportId) {

        if(airportRepository.existsById(airpportId)){
            airportRepository.deleteById(airpportId);
        return true;}

        else
            return false;

    }
}
