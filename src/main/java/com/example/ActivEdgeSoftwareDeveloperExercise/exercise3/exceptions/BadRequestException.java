package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
