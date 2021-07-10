package ru.job4j.ood.srp;

import java.util.List;

public interface Report {
    List<String> load(String path);
    List<String> validate(List<String> data);
    void save(List<String> data, String path);
}
