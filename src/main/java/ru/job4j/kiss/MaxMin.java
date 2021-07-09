package ru.job4j.kiss;

import java.util.*;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> min = v -> v < 0;
        return minMax(value, comparator, min);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> max = v -> v > 0;
        return minMax(value, comparator, max);
    }

    private <T> T minMax(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (T t : value) {
            if (predicate.test(comparator.compare(rsl, t))) {
                rsl = t;
            }
        }
        return rsl;
    }
}
