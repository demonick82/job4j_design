package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

public class Engine {
    private final String serialNumber;
    private final double volume;

    public Engine(String serialNumber, double volume) {
        this.serialNumber = serialNumber;
        this.volume = volume;
    }
    ///@JSONPropertyIgnore

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "SerialNumber='" + serialNumber + '\''
                + ", volume=" + volume
                + '}';
    }
}
