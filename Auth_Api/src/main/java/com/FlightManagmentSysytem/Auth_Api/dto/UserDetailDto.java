package com.FlightManagmentSysytem.Auth_Api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetailDto {
    private String email;
    private String password;
    private String role;  // you still had roles in Employee model
}
