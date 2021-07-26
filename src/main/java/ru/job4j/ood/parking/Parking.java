package ru.job4j.ood.parking;

public interface Parking {
    int getParkingFreeSpace();
    boolean canPark(Car car);
}
