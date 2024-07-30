package com.demo.Exp3.entities;


import lombok.Getter;

@Getter
public enum Role {
    USER("user"),
    ADMIN("Admin");

    final String value;

    Role(String value){
        this.value = value;
    }

    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.getValue().equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
