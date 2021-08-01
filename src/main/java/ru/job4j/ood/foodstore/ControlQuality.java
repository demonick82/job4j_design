package ru.job4j.ood.foodstore;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> storage;

    public ControlQuality(List<Store> storage) {
        this.storage = storage;
    }

    public void redistribute(Food food) {
        for (Store store : storage) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> resortList = new ArrayList<>();
        for (Store store : storage) {
            resortList.addAll(store.getAndClear());
        }
        for (Food food : resortList) {
            redistribute(food);
        }
    }

    public static void main(String[] args) {
        List<Store> stores = List.of(new Shop(), new Warehouse(), new Trash());
        ControlQuality controlQuality = new ControlQuality(stores);

        Food sausage1 = new Sausage("Колбаса докторская", LocalDate.of(2021, Month.JUNE, 20),
                LocalDate.of(2021, Month.JULY, 25), 320.2, 20);
        Food sausage2 = new Sausage("Колбаса сервелат", LocalDate.of(2021, Month.JUNE, 20),
                LocalDate.of(2021, Month.JULY, 25), 500., 20);
        Food cheese = new Cheese("Сыр российский", LocalDate.of(2021, Month.JUNE, 20),
                LocalDate.of(2021, Month.JULY, 15), 600.0, 20);
        Food cheese2 = new Cheese("Сыр пошехонский", LocalDate.of(2021, Month.JUNE, 20),
                LocalDate.of(2021, Month.JULY, 31), 400.0, 20);
        Food pasta = new Pasta("Барилла", LocalDate.of(2021, Month.MAY, 20),
                LocalDate.of(2021, Month.SEPTEMBER, 15), 80.0, 20);
        Food sausage3 = new Sausage("Колбаса брауншвейгская", LocalDate.of(2021, Month.JULY, 15),
                LocalDate.of(2021, Month.AUGUST, 25), 989.2, 20);
        controlQuality.redistribute(sausage1);
        controlQuality.redistribute(sausage2);
        controlQuality.redistribute(sausage3);
        controlQuality.redistribute(cheese);
        controlQuality.redistribute(cheese2);
        controlQuality.redistribute(pasta);
        controlQuality.resort();
    }
}
