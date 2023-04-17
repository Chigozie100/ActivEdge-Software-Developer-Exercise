package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequestDto {
    private String name;
    private BigDecimal currentPrice;
}
