package com.demo.Exp3.services;

import com.demo.Exp3.Dto.AuthRequest;
import com.demo.Exp3.Dto.RoleRequest;
import com.demo.Exp3.config.auth.TokenProvider;
import com.demo.Exp3.entities.Role;
import com.demo.Exp3.entities.User;
import com.demo.Exp3.enums.Status;
import com.demo.Exp3.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Autowired
    TokenProvider tokenProvider;

    public Status registerUser(AuthRequest request){
        if(userRepository.findByUsername(request.getUserName())!=null){
            return Status.USERNAME_TAKEN;
        }

        User user = new User();
        user.setUsername((request.getUserName()));
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        return Status.SUCCESS ;
    }

    public Status setRole(RoleRequest request){

        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(request.getId()));
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setRole(request.getRole());
            userRepository.save(user);
            return Status.SUCCESS;
        }
        return Status.USER_NOT_FOUND;
    }

    public String getUsername(String token){
        return tokenProvider.validateToken(token);
    }
}
