package com.brancucci;

import com.brancucci.domain.Car;
import com.brancucci.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		logger.info("Logging in Spring Boot");
	}

	@Bean
	CommandLineRunner runner (){
		return args -> {
			carRepository.save(new Car("Ford", "Mustang", "Red", "AFD-1121", 2017, 59000));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000));
		};
	}

}
