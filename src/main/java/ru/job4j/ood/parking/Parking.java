package ru.job4j.ood.parking;

public interface Parking {
    void getParkingPosition(Car car);
    boolean canPark(Car car);
}
