package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.exceptions;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.dtos.APIResponse;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.utils.Responder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> ResourceNotFound(ResourceNotFoundException ex){
        return Responder.notFound(ex.getMessage());
    }
}
