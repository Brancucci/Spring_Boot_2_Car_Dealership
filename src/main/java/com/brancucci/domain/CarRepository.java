package com.brancucci.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    // fetch cars by brand
    List<Car> findByBrand(String brand);

    // fetch by color
    List<Car> findByColor(String color);

    // fetch by year
    List<Car> findByYear(int year);

    // we can query
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);
}
