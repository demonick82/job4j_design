package ru.job4j.ood.foodstore;

import java.time.LocalDate;

public class Pasta extends Food {
    public Pasta(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
