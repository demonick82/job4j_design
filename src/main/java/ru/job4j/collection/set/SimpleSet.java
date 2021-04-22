package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(Object value) {
        if (!contains(value)) {
            set.add((T) value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        for (T t : set) {
            if (Objects.equals(value, t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
