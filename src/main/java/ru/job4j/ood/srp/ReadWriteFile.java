package ru.job4j.ood.srp;

import java.util.List;

public interface ReadWriteFile {
    List<String> reader(String path);
    void write(List<String> in, String path);
}

