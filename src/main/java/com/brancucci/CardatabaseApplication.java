package com.brancucci;

import com.brancucci.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Logging in Spring Boot");
	}

	@Bean
	CommandLineRunner runner (){
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			carRepository.save(new Car("Ford", "Mustang", "Red", "AFD-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));

			// authentication and authorization
			userRepository.save(new User("user",
					"$2a$10$OgSv/8UF1DZS.Io7L/EFqefNkyTJ1pGOt6PFvLpiusmxzpJWQT2ri",
					"USER"));
			userRepository.save(new User("admin",
					"$2a$10$G8nwDgr.yUf/J0twjjFvxeyCm7yjEOxgccX4vbVM6ZUUaOd10tKvu",
					"ADMIN"));
		};
	}

}
