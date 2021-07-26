package ru.job4j.ood.parking;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class CarParkingTest {

    @Test
    public void whenCanPark() {
        Car car1 = new PassengerCar();
        Parking parking = new CarParking(10);
        assertTrue(parking.canPark(car1));
    }

    @Test
    public void whenCanNotPark() {
        Car car1 = new Truck(5);
        Car car2 = new Truck(6);
        Parking parking = new CarParking(10);
        parking.canPark(car1);
        assertFalse(parking.canPark(car2));
    }

    @Test
    public void freeSpace() {
        Car car1 = new Truck(5);
        Parking parking = new CarParking(10);
        parking.canPark(car1);
        assertThat(parking.getParkingFreeSpace(),is(5));
    }
}