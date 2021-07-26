package ru.job4j.dip;


import java.util.ArrayList;
import java.util.List;

public class BadMemStore {
    List<String> store = new ArrayList<>();

    public void add(String text) {
        store.add(text);
    }
    public String find(String text) {
        return store.contains(text) ? text : "not found";
    }
}
