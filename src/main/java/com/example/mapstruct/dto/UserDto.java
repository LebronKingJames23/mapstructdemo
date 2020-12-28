package com.example.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;

    private String password;

    private String deliveryCode;

    private String address;

    private String phone;

    private String carNo;

    private String type;

    private String carPrice;

    private String id;

    private String height;

    private String weight;

    private String name;
}
