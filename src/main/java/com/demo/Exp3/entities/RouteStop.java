package com.demo.Exp3.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RouteStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="route_id")
    @JsonBackReference
    private Route route;

    @ManyToOne
    @JoinColumn(name="stop_id")
    @JsonBackReference
    private Stop stop;

    private int stopOrder;

}
