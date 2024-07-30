package com.demo.Exp3.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthResponse {
    @Getter
    @Setter
    private String token;

}
