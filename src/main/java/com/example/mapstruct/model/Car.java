package com.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String num;

    private String type;

    private String price;

    private double miles;

    private BigDecimal speed;

    private Long length;
}
