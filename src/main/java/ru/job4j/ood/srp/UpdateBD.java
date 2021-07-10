package ru.job4j.ood.srp;

import java.util.List;

public interface UpdateBD {
    List<String> readFile(String path);
    void saveBD(List<String> data);
}
