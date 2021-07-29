package ru.job4j.ood.foodstore;


import java.util.List;

public interface Store {
    void add(Food food);

    boolean accept(Food food);
    List<Food> getAndClear();
}
