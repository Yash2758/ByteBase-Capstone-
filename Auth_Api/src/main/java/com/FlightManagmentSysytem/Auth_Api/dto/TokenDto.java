package com.FlightManagmentSysytem.Auth_Api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenDto {
    private boolean isValid;
    private String token;  // add token value if login succeeds
}
