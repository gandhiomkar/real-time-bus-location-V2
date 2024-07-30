package com.demo.Exp3.enums;

import lombok.Getter;

@Getter
public enum Status {
    SUCCESS("success"),
    FAIL("failed"),
    BAD_CREDENTIALS("Bad creadentials"),
    USERNAME_TAKEN("Username is already taken"),
    ROLE_UPDATE_FAILED("Failed to update role"),
    USER_NOT_FOUND("user not found");

    private final String message;

    Status(String value){
        this.message=value;
    }
}
