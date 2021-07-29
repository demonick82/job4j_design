package ru.job4j.ood.parking;

import ru.job4j.ood.parking.models.Car;
import ru.job4j.ood.parking.models.PassengerCar;
import ru.job4j.ood.parking.models.Truck;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    private int carPoints;
    private int truckPoint;
    private List<Car> cars = new ArrayList<>();

    public CarParking(int carPoints, int truckPoint) {
        this.carPoints = carPoints;
        this.truckPoint = truckPoint;
    }

    @Override
    public List<Car> getCarOnParking() {
        return cars;
    }

    @Override
    public boolean canPark(Car car) {
        boolean rsl = false;
        if (car.getClass() == PassengerCar.class) {
            if (carPoints > 0) {
                carPoints = carPoints - 1;
                cars.add(car);
                rsl = true;
            }
        }
        if (car.getClass() == Truck.class) {
            if (truckPoint > 0) {
                truckPoint = truckPoint - 1;
                cars.add(car);
                rsl = true;
            } else if (car.getSize() < carPoints) {
                carPoints = carPoints - car.getSize();
                cars.add(car);
                rsl = true;
            }
        }
        return rsl;
    }
}
