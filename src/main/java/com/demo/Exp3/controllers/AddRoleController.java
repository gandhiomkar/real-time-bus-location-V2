package com.demo.Exp3.controllers;

import com.demo.Exp3.Dto.RoleRequest;
import com.demo.Exp3.enums.Status;
import com.demo.Exp3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AddRoleController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/set_role")
    public ResponseEntity<String> setRole(@RequestBody RoleRequest request){
        Status response = userService.setRole(request);
        if (response == Status.SUCCESS){
            return ResponseEntity.ok("User Role Set");
        }
        return ResponseEntity.badRequest().body(response.getMessage());
    }

}
