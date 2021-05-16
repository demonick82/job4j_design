package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesFinder {

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        DuplicatesFinder finder = new DuplicatesFinder();
        if (args.length == 0) {
            throw new IllegalArgumentException("Не заданы аргументы коммандной строки");
        }
        Path start = Paths.get(args[0]);
        if (!Files.exists(start)) {
            throw new IllegalArgumentException("Выбранная директория не существует");
        }
        Files.walkFileTree(Path.of(start.toString()), visitor);
        for (FileProperty fileProperty : finder.duplicateFile(visitor.getPaths())) {
            System.out.printf("Найден дубликат файла %s", fileProperty.getName());
        }
    }

    public List<FileProperty> duplicateFile(List<FileProperty> list) {
        Set<FileProperty> compareSet = new HashSet<>();
        List<FileProperty> rsl = new ArrayList<>();
        for (FileProperty property : list) {
            if (!compareSet.add(property)) {
                rsl.add(property);
            }
        }
        return rsl;
    }
}
