package com.demo.Exp3.services;

import com.demo.Exp3.entities.Route;
import com.demo.Exp3.entities.RouteStop;
import com.demo.Exp3.enums.Status;
import com.demo.Exp3.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StopService stopService;

    public List<Route> getRouteByStops(String from, String to){
        return routeRepository.findRoutesBetweenStops(from,to);
    }

    public Route createRoute(String name){
        Route route = new Route();
        route.setName(name);
        return routeRepository.save(route);
    }

}
