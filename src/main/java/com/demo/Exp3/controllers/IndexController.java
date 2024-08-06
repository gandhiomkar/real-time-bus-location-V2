package com.demo.Exp3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class IndexController {
    @GetMapping("/bus-tracker")
    public String getBusTrackerPage() {
        return "bus-tracker";
    }

    @GetMapping("/show-bus")
    public String showBus(){
        return "bus";
    }
}





