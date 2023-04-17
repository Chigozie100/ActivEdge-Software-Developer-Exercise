package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.controllers;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.APIResponse;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockRequestDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.services.StockService;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.utils.Constants;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.utils.Responder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/stocks")
@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockService service;
    private final Responder responder;

    @PostMapping
    public ResponseEntity<APIResponse> createStock(@RequestBody StockRequestDto requestDto){
        return responder.okay(service.createStock(requestDto));
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<APIResponse> getStock(@PathVariable Long stockId){
        return  responder.okay(service.getStock(stockId));
    }

    @GetMapping("/getStocks")
    public ResponseEntity<Page<Stock>> getStocks(@RequestParam(defaultValue = Constants.PAGENO) Integer pageNo,
                                                       @RequestParam(defaultValue = Constants.PAGESIZE) Integer pageSize,
                                                       @RequestParam(defaultValue = "id") String sortBy) {
        Page<Stock> pagedResult = service.getAllStocks(pageNo, pageSize, sortBy);

        if(pagedResult.hasContent()) {
            return new ResponseEntity<>(pagedResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{stockId}")
    public ResponseEntity<APIResponse> updateStock(@PathVariable(name = "stockId") Long stockId,
                                                         @RequestBody StockRequestDto requestDto){
        return responder.okay(service.updateStock(stockId, requestDto));
    }

}
