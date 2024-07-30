package com.demo.Exp3.controllers;

import com.demo.Exp3.config.auth.TokenProvider;
import com.demo.Exp3.security.JWTAuthenticationFilter;
import com.demo.Exp3.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;



    @GetMapping(value = {"/","/home"})
    public String home(){
        return "hello there";
    };

    @GetMapping("/user")
    public String usermapping(HttpServletRequest request){
        return "hello "+ userService.getUsername(jwtAuthenticationFilter.recoverToken(request));
    };

    @GetMapping("/admin")
    public String admin(){
        return "hola Amigo!";
    };
}
