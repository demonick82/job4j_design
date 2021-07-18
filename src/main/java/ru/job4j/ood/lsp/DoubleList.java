package ru.job4j.ood.lsp;

import java.util.ArrayList;

public class DoubleList<E> extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        add(e);
        add(e);
        return true;
    }
}
