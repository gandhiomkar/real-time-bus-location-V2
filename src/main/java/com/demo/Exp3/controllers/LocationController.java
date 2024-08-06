package com.demo.Exp3.controllers;

import com.demo.Exp3.Dto.Location;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;

@Controller
public class LocationController {

    @MessageMapping("/bus/{busId}/location")
    @SendTo("/topic/bus/{busId}/location")
    public Location updateLocation(@DestinationVariable String busId, Location location) {
        return location;
    }
}
