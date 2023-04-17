package com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.repositories;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByName(String name);
}
