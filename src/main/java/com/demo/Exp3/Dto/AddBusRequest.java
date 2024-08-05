package com.demo.Exp3.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddBusRequest {
    private Long routeId;
    private String departureTime;
}
