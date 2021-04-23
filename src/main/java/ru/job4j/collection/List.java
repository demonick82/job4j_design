package ru.job4j.collection;

import java.util.ListIterator;

public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
