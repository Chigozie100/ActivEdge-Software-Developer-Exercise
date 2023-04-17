package com.example.ActivEdgeSoftwareDeveloperExercise;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
@RequiredArgsConstructor
public class ActivEdgeSoftwareDeveloperExerciseApplication implements CommandLineRunner {
	private final StockRepository stockRepository;

	public static void main(String[] args) {
		SpringApplication.run(ActivEdgeSoftwareDeveloperExerciseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!(stockRepository.findAll().size() > 0)){
			stockRepository.save(new Stock("Bank of America Corp", BigDecimal.valueOf(20000000)));
			stockRepository.save(new Stock("Apple Inc", BigDecimal.valueOf(40000000)));
			stockRepository.save(new Stock("Gibraltar Industries Inc", BigDecimal.valueOf(50000000)));
			stockRepository.save(new Stock("American Virtual Cloud Technologies, Inc.", BigDecimal.valueOf(50000000)));

		}

	}
}
