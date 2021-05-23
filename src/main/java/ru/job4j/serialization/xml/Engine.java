package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "engine")
public class Engine {

    @XmlAttribute
    private String serialNumber;
    @XmlAttribute
    private double volume;

    public Engine(String serialNumber, double volume) {
        this.serialNumber = serialNumber;
        this.volume = volume;
    }

    public Engine() {

    }

    @Override
    public String toString() {
        return "Engine{"
                + "SerialNumber='" + serialNumber + '\''
                + ", volume=" + volume
                + '}';
    }
}
