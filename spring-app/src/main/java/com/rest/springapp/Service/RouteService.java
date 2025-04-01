package com.rest.springapp.Service;

import com.rest.springapp.entities.Route;
import com.rest.springapp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Page<Route> getAllRoutes(Pageable pageable) {
        return routeRepository.findAll(pageable);
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route updateRoute(Long id, Route routeDetails) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        route.setRouteName(routeDetails.getRouteName());
        return routeRepository.save(route);
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
