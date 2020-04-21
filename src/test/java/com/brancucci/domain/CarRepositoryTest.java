package com.brancucci.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveCar(){
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        testEntityManager.persistAndFlush(car);
        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars(){
        Car car1 = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        Car car2 = new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500);

        testEntityManager.persistAndFlush(car1);
        testEntityManager.persistAndFlush(car2);
        carRepository.deleteAll();
        assertThat(carRepository.findAll()).isEmpty();

    }
}
