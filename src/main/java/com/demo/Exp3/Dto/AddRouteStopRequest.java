package com.demo.Exp3.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRouteStopRequest {

    private Long routeId;
    private String currentStopName;
    private String newStopName;
}
