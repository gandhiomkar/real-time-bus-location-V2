package com.demo.Exp3.services;

import com.demo.Exp3.entities.Route;
import com.demo.Exp3.entities.RouteStop;
import com.demo.Exp3.entities.Stop;
import com.demo.Exp3.repositories.RouteRepository;
import com.demo.Exp3.repositories.RouteStopRepository;
import com.demo.Exp3.repositories.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteStopService {
    @Autowired
    private RouteStopRepository routeStopRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StopRepository stopRepository;

    public Optional<RouteStop> findNextStop(Long routeId, Integer currentStopOrder) {
        List<RouteStop> nextStops = routeStopRepository.findNextStopOrder(routeId, currentStopOrder);
        return nextStops.stream().findFirst();
    }

    @Transactional
    public RouteStop addRouteStop(Route route, Long currentStopId, Stop newStop ){
        RouteStop currentStop = routeStopRepository.findByRouteIdAndStopId(route.getId(), currentStopId)
                .orElseThrow(() -> new IllegalArgumentException("Current stop not found"));


        RouteStop nextStop = findNextStop(route.getId(), currentStop.getStopOrder()).orElseThrow(()->new IllegalArgumentException("route or current stop not found"));
        int newStopOrder = (currentStop.getStopOrder() + nextStop.getStopOrder()) / 2;


        RouteStop newRouteStop = new RouteStop();
        newRouteStop.setRoute(route);
        newRouteStop.setStop(newStop);
        newRouteStop.setStopOrder(newStopOrder);

        return routeStopRepository.save(newRouteStop);
    }

    @Transactional
    public RouteStop addStopAtEnd(Long routeId, String newStopName) {
        Long newStopId = stopRepository.findByName(newStopName).getId();

        Integer maxStopOrder = routeStopRepository.findMaxStopOrderByRouteId(routeId);
        int nextStopOrder = (maxStopOrder != null) ? maxStopOrder + 1000 : 1000;

        Stop newStop = stopRepository.findById(newStopId)
                .orElseThrow(() -> new IllegalArgumentException("New stop not found"));

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));

        RouteStop newRouteStop = new RouteStop();
        newRouteStop.setRoute(route);
        newRouteStop.setStop(newStop);
        newRouteStop.setStopOrder(nextStopOrder);

        return routeStopRepository.save(newRouteStop);
    }

    public RouteStop addRouteStopByName(Long routeId, String currentStopName, String newStopName){
        Route route = routeRepository.findById(routeId)
                .orElseThrow(()->new IllegalArgumentException("route not found"));

        Stop currentStop = stopRepository.findByName(currentStopName);

        Stop newStop = stopRepository.findByName(newStopName);

        return addRouteStop(route, currentStop.getId(), newStop);

    }

    public List<Stop> getStopsByRouteId(Long routeId) {
        List<RouteStop> routeStops = routeStopRepository.findAllByRouteIdOrderByStopOrder(routeId);
        return routeStops.stream()
                .map(RouteStop::getStop)
                .collect(Collectors.toList());
    }

}
