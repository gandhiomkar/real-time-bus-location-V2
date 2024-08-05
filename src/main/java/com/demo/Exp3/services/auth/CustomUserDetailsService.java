package com.demo.Exp3.services.auth;

import com.demo.Exp3.entities.auth.User;
import com.demo.Exp3.repositories.auth.UserRepository;
import com.demo.Exp3.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("username not found");
        }
        return new CustomUserDetails(user);
    }
}
