package ru.job4j.serialization.json;

public class Engine {
    private final String serialNumber;
    private final double volume;

    public Engine(String serialNumber, double volume) {
        this.serialNumber = serialNumber;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "SerialNumber='" + serialNumber + '\''
                + ", volume=" + volume
                + '}';
    }
}
