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
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<RouteStop> routeStops = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Bus> buses = new ArrayList<>();

}
