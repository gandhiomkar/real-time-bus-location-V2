package com.demo.Exp3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping(value = {"/","/home"})
    public String home(){
        return "hello there";
    };

    @GetMapping("/user")
    public String usermapping(){
        return "hello User";
    };

    @GetMapping("/admin")
    public String admin(){
        return "hola Amigo!";
    };
}
