package com.FlightManagmentSysytem.Auth_Api.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Operation {
    private UUID id;
    private String name;
    private String description;
}
