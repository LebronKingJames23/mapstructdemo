package com.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;

    private String password;

    private String code;

    private String deliveryAddress;

    private String mobile;

    private Integer height;

    private boolean weight;

    private String name;
}
