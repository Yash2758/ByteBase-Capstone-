package com.FlightManagmentSysytem.Auth_Api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    private UUID id;
    private String name;
    private List<Operation> operations;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
