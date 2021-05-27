package ru.job4j.io.filefind;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Задайте параметрв поиска файлов: начальную директорию и расширение");
        }
        Path start = Paths.get(args[0]);
        String pred = args[1];
        if (!Files.exists(start)) {
            throw new IllegalArgumentException("Выбранная директория не сущществует");
        }

        search(start, p -> p.toFile().getName().endsWith(pred)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static List<Path> searchRegex(Path root, Pattern pattern) throws IOException {
        SearchFiles searcher = new SearchFiles(pattern);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

}
