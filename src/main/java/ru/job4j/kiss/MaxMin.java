package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    public <T> T minMax(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, rsl) > 0) {
                rsl = t;
            }
        }
        return rsl;
    }
}
