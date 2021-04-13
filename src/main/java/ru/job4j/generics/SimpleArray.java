package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int count = 0;
    private int countIt = 0;

    public SimpleArray(int length) {
        data = new Object[length];
    }

    public void add(T model) {
        data[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, data.length);
        data[index] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, data.length);
        return (T) data[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, data.length);
        data[index] = null;
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        count--;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return countIt < data.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[countIt++];
            }
        };
        return iterator;
    }
}
