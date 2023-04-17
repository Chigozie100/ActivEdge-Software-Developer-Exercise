package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.services;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockRequestDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockResponseDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.exceptions.ResourceNotFoundException;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{
    private final StockRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public StockResponseDto createStock(StockRequestDto requestDto) {
        repository.findByName(requestDto.getName()).ifPresent(address -> {
            throw  new ResourceNotFoundException(" stock already exist");
        });
        Stock stock = modelMapper.map(requestDto, Stock.class);
        return modelMapper.map(repository.save(stock), StockResponseDto.class);
    }

}
