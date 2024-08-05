package com.demo.Exp3.controllers;

import com.demo.Exp3.Dto.*;
import com.demo.Exp3.entities.Bus;
import com.demo.Exp3.entities.Route;
import com.demo.Exp3.entities.RouteStop;
import com.demo.Exp3.entities.Stop;
import com.demo.Exp3.services.BusService;
import com.demo.Exp3.services.RouteService;
import com.demo.Exp3.services.RouteStopService;
import com.demo.Exp3.services.StopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusService busService;

    @Autowired
    private RouteStopService routeStopService;

    @Autowired
    private StopService stopService;

    @GetMapping("/getRoute")
    public ResponseEntity<List<Route>> getRoute(@RequestBody RouteRequest request){
        List<Route> routes = routeService.getRouteByStops(request.getFrom(), request.getTo());
        return ResponseEntity.ok(routes);
    }

    @PostMapping("/createRoute")
    public ResponseEntity<Route> createRoute(@RequestBody AddRouteRequest request){
        Route route = routeService.createRoute(request.getName());
        if(route!=null){
        return ResponseEntity.ok(route);}
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/getStopsOnRoute")
    public ResponseEntity<List<Stop>> getStopsOnRoute(@RequestParam Long routeId){
       return ResponseEntity.ok(routeStopService.getStopsByRouteId(routeId));
    }

    @PostMapping("/createStop")
    public ResponseEntity<Stop> createStop(@RequestBody AddStopRequest request){
        return ResponseEntity.ok(stopService.createStop(request.getName()));
    }


    @PostMapping("/addRouteStopBetween")
    public RouteStop addStopBetween(@RequestBody AddRouteStopRequest request) {
        return routeStopService.addRouteStopByName(request.getRouteId(), request.getCurrentStopName(), request.getNewStopName());
    }

    @PostMapping("/addRouteStop")
    public RouteStop addStopAtEnd(@RequestBody AddRouteStopRequest request) {
        return routeStopService.addStopAtEnd(request.getRouteId(), request.getNewStopName());
    }


    @GetMapping("/getBus")
    public ResponseEntity<List<Bus>> getBuses(@RequestBody RouteRequest request){
        List<Bus>  buses = busService.getBusesByStops(request.getFrom(),request.getTo());
        if (buses!=null){
            return ResponseEntity.ok(buses);
        }
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping("/createBus")
    public Bus createBus(@RequestBody AddBusRequest request) {
        LocalTime time = LocalTime.parse(request.getDepartureTime());
        return busService.createBus(request.getRouteId(), time);
    }
}
