package ru.job4j.ood.parking;

public class CarParking implements Parking {
    private int size;

    public CarParking(int size) {
        this.size = size;
    }

    @Override
    public int getParkingFreeSpace() {
        return size;
    }

    @Override
    public boolean canPark(Car car) {
        boolean rsl = false;
        if (car.getSize() < this.size) {
            size = size - car.getSize();
            rsl = true;
        }
        return rsl;
    }
}
