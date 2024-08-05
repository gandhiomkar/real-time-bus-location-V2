package com.demo.Exp3.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "stop",cascade = CascadeType.ALL)
    private List<RouteStop> routeStops = new ArrayList<>();
}
