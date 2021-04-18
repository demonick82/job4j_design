package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private int modCount = 0;

    public SimpleArray() {
        container = new Object[DEFAULT_SIZE];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size >= container.length) {
            newArray();
        }
        modCount++;
        container[size++] = model;
    }

    private void newArray() {
         container = Arrays.copyOf(container, (int) (size * 1.5 + 1));
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>();
    }

    private class SimpleArrayIterator<T> implements Iterator<T> {

        private final int expectedModCount;
        private int cursor = 0;

        public SimpleArrayIterator() {
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[cursor++];
        }

    }
}
