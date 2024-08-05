package com.demo.Exp3.entities.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Getter
            @Setter
    String username;

    @Getter
            @Setter
    String password;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    Role role;

}
