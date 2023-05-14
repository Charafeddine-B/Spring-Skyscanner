package com.flight.scanner.Managment.services.serviceImpl;

import com.flight.scanner.Managment.model.Plane;
import com.flight.scanner.Managment.repository.PlaneRepository;
import com.flight.scanner.Managment.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    public PlaneRepository planeRepository;

    @Override
    public Page<Plane> getAllPlanesPaged(int pageNum) {
        return planeRepository.findAll(PageRequest.of(pageNum,5,Sort.by("model")));
    }

    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public Plane getPlaneById(Long planeId) {
        return planeRepository.findById(planeId).orElse(null);
    }

    @Override
    public Plane savePlane(Plane plane) {
        if(plane==null) throw new IllegalArgumentException();
        return planeRepository.save(plane);
    }


    @Override
    public void deletePlaneById(Long planeId) {
    planeRepository.deleteById(planeId);
    }
}
