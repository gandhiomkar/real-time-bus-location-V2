package com.demo.Exp3.services.auth;

import com.demo.Exp3.config.auth.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenProvider tokenProvider;

    public String authenticate(String userName, String password){
        try {
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return tokenProvider.generateAccessToken(userDetails);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
