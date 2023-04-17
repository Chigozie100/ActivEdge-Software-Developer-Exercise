package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.controllers;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.APIResponse;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.StockRequestDto;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.services.StockService;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.utils.Responder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/stocks/")
@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockService service;
    private final Responder responder;

    @PostMapping
    public ResponseEntity<APIResponse> addAddressBook(@RequestBody StockRequestDto requestDto){
        return responder.okay(service.createStock(requestDto));
    }

}
