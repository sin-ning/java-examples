package com.joysrun.classloader.examples;

import com.joysrun.spi.examples.Car;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * author: sin
 * time: 2019-08-17 10:01
 */
public class CarTest {

    @Test
    public void spiLoaderTest() {
        ServiceLoader<Car> cars = ServiceLoader.load(Car.class);

        System.err.println("car size: " + cars);
        for (Car car : cars) {
            System.err.println(car.getName());
        }
    }
}
