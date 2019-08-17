package com.joysrun.spi.examples2;

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
        System.err.println("Car ClassLoader: " + Car.class.getClassLoader());
        System.err.println("ServiceLoader ClassLoader: " + ServiceLoader.class.getClassLoader());
        int count = 0;
        for (Car car : cars) {
            System.err.println(car.getName());
            count++;
        }
        System.err.println("Car size: " + count);
    }
}
