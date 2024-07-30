package com.demo.Exp3.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {
    @NonNull
    String userName;
    String password;
}
