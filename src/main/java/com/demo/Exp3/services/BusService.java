package com.demo.Exp3.services;

import com.demo.Exp3.entities.Bus;
import com.demo.Exp3.entities.Route;
import com.demo.Exp3.repositories.BusRepository;
import com.demo.Exp3.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteService routeService;

    public List<Bus> getBusesByStops(String from, String to){
        List<Route> routes= routeService.getRouteByStops(from,to);
        return routes.stream().flatMap(route -> route.getBuses().stream()).toList();
    }

    public List<Bus> getBusesByRoute(Long routeId) {
        Optional<Route> route = routeRepository.findById(routeId);
        if (route.isPresent()) {
            return busRepository.findByRoute(route.get());
        }
        return Collections.emptyList();
    }

    public Bus createBus(Long routeId, LocalTime time){
        Bus bus = new Bus();
        bus.setRoute(routeRepository.findById(routeId)
                .orElseThrow(()->new IllegalArgumentException("route not found")));
        bus.setDepartureTime(time);
        return busRepository.save(bus);

    }
}
