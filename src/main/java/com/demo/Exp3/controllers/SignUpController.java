package com.demo.Exp3.controllers;

import com.demo.Exp3.Dto.AuthRequest;
import com.demo.Exp3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class SignUpController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody AuthRequest request){
        String response = userService.registerUser(request).getMessage();
        if(response.equals("User registered successfully")){
        return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body(response);
    }
}
