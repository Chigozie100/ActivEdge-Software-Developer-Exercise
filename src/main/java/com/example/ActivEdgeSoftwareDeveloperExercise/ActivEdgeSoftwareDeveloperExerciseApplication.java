package com.example.ActivEdgeSoftwareDeveloperExercise;

import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.models.Stock;
import com.example.ActivEdgeSoftwareDeveloperExercise.exercise3.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.math.BigDecimal;

import static com.example.ActivEdgeSoftwareDeveloperExercise.exercise1.SmallestNonOccurringInteger.findSmallestNonOccurringInteger;

@SpringBootApplication
@RequiredArgsConstructor
public class ActivEdgeSoftwareDeveloperExerciseApplication implements CommandLineRunner {
	private final StockRepository stockRepository;

	public static void main(String[] args) {
		SpringApplication.run(ActivEdgeSoftwareDeveloperExerciseApplication.class, args);
		int[] arr1 = {1, 3, 6, 4, 1, 2};
		int smallestNonOccurringInteger1 = findSmallestNonOccurringInteger(arr1);
		System.out.println(smallestNonOccurringInteger1); // output: 5

		int[] arr2 = {5, -1, -3};
		int smallestNonOccurringInteger2 = findSmallestNonOccurringInteger(arr2);
		System.out.println(smallestNonOccurringInteger2); // output: 1
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
