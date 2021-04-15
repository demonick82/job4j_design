package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (findIndex(id) != -1) {
            mem.set(findIndex(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (findIndex(id) != -1) {
            mem.remove(findIndex(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        if (findIndex(id) != -1) {
            return mem.get(findIndex(id));
        }
        return null;
    }

    private int findIndex(String id) {
        int rsl = 0;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rsl = i;
                break;
            } else {
                rsl = -1;
            }
        }
        return rsl;
    }
}
