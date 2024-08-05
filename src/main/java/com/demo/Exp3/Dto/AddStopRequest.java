package com.demo.Exp3.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStopRequest {
    private Long routeId;
    private String name;
}