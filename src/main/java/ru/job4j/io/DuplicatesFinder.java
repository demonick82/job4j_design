package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DuplicatesFinder {

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        if (args.length == 0) {
            throw new IllegalArgumentException("Не заданы аргументы коммандной строки");
        }
        Path start = Paths.get(args[0]);
        if (!Files.exists(start)) {
            throw new IllegalArgumentException("Выбранная директория не существует");
        }
        Files.walkFileTree(Path.of(start.toString()), visitor);
        for (FileProperty fileName : visitor.getPaths()) {
            System.out.printf("Найдены дубликаты файла %s", fileName.getName());
        }
    }
}
