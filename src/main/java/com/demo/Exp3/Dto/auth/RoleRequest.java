package com.demo.Exp3.Dto.auth;

import com.demo.Exp3.entities.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoleRequest {
    long id;
    String username;
    Role role;
}
