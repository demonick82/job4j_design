package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return isCheck(data, point);
    }

    @Override
    public Integer next() {
        int rsl;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            rsl = data[point];
            point++;
        }
        return rsl;
    }

    private boolean isCheck(int[] data, int position) {
        for (int i = position; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                point = i;
                return true;
            }
        }
        return false;
    }
}
