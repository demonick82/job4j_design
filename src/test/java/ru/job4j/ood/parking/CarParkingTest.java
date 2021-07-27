package ru.job4j.ood.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarParkingTest {

    @Test
    public void whenCanPark() {
        Car car1 = new PassengerCar();
        Parking parking = new CarParking(10,5);
        assertTrue(parking.canPark(car1));
    }

    @Test
    public void whenCanNotPark() {
        Car car1 = new PassengerCar();
        Car car2 = new Truck(3);
        Car car3 = new Truck(3);
        Parking parking = new CarParking(1,1);
        parking.canPark(car1);
        parking.canPark(car2);
        assertFalse(parking.canPark(car3));
    }

    @Test
    public void whenTruckParkToCarPoint() {
        Car car1 = new PassengerCar();
        Car car2 = new Truck(3);
        Car car3 = new Truck(3);
        Parking parking = new CarParking(10,1);
        parking.canPark(car1);
        parking.canPark(car2);
        assertTrue(parking.canPark(car3));
    }
}