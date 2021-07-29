package ru.job4j.ood.parking;

import ru.job4j.ood.parking.models.Car;

import java.util.List;

public interface Parking {
    List<Car> getCarOnParking();
    boolean canPark(Car car);
}
