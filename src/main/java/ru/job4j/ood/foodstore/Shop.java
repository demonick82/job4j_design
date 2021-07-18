package ru.job4j.ood.foodstore;


import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        if (food.expirePercent() >= 25 && food.expirePercent() <= 75) {
            System.out.printf("Продукт %s поступил в магазин, его стоимость %s %s", food.getName(), food.getPrice(),
                    System.lineSeparator());
            rsl = true;
        } else if (food.expirePercent() < 25 && food.expirePercent() > 0) {
            food.setPrice(priceWithDiscount(food.getPrice(), food.getDiscount()));
            System.out.printf("Продукт %s поступил в магазин со скидкой, его стоимость %s %s",
                    food.getName(), food.getPrice(), System.lineSeparator());
            rsl = true;
        }
        return rsl;
    }

    private double priceWithDiscount(double price, double discount) {
        return price * (1 - discount / 100);
    }
}
