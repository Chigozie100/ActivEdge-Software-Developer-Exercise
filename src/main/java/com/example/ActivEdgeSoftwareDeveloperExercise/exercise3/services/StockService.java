package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.services;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockRequestDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockResponseDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import org.springframework.data.domain.Page;

public interface StockService {
    StockResponseDto createStock(StockRequestDto requestDto);

//    StockResponseDto getStock(Long stockId);
//
//    Page<Stock> getAllStocks(int pageNo, int pageSize, String sortBy);
//
//    StockResponseDto updateStock(Long stockId, StockRequestDto requestDto);
}
