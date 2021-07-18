package ru.job4j.ood.foodstore;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        if (food.expirePercent() <= 0) {
            System.out.printf("Продукт %s испортился%s", food.getName(), System.lineSeparator());
            rsl = true;
        }
        return rsl;
    }
}
