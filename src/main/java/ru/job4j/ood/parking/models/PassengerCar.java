package ru.job4j.ood.parking.models;

public class PassengerCar implements Car {
    private final int size = 1;

    @Override
    public int getSize() {
        return size;
    }
}
