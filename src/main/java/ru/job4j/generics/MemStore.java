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
        int idSearch = findIndex(id);
        if (idSearch != -1) {
            mem.set(idSearch, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int idSearch = findIndex(id);
        if (idSearch != -1) {
            mem.remove(idSearch);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int idSearch = findIndex(id);
        if (idSearch != -1) {
            return mem.get(findIndex(id));
        }
        return null;
    }

    private int findIndex(String id) {
        int rsl = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
