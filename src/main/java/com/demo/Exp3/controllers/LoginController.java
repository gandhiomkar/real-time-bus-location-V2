package com.demo.Exp3.controllers;

import com.demo.Exp3.Dto.AuthResponse;
import com.demo.Exp3.Dto.AuthRequest;
import com.demo.Exp3.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        String token = authenticationService.authenticate(request.getUserName(), request.getPassword());
        if(token !=null){
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body("not authorized");
    }
}
