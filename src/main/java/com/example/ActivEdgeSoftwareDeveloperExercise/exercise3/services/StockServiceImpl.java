package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.services;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockRequestDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockResponseDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.exceptions.ResourceNotFoundException;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public StockResponseDto getStock(Long stockId) {
        Optional<Stock> getStock = repository.findById(stockId);
        return modelMapper.map(getStock, StockResponseDto.class);
    }

    @Override
    public Page<Stock> getAllStocks(int pageNo, int pageSize, String sortBy) {
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return repository.findAll(paging);
    }

    @Override
    public StockResponseDto updateStock(Long stockId, StockRequestDto requestDto) {
        Stock stock = repository.findById(stockId).orElseThrow(()-> new ResourceNotFoundException("stock not found"));
        stock.setCurrentPrice(requestDto.getCurrentPrice());
        Stock save = repository.save(stock);
        return modelMapper.map(save, StockResponseDto.class);
    }

}
