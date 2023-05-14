package com.flight.scanner.Managment.services;

import com.flight.scanner.Managment.model.Plane;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlaneService {
    public abstract Page<Plane> getAllPlanesPaged(int pageNum);
    public abstract List<Plane> getAllPlanes();
    public abstract Plane getPlaneById(Long planeId);
    public abstract Plane savePlane(Plane plane);
    public abstract void deletePlaneById(Long planeId);
}
