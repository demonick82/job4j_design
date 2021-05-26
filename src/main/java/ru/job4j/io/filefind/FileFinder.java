package ru.job4j.io.filefind;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class FileFinder {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Неверно заданы параметры коммандной строки");
        }
        String pathSearch = ArgsName.of(args).get("d");
        String fileName = ArgsName.of(args).get("n");
        String searchType = ArgsName.of(args).get("t");
        String rslPath = ArgsName.of(args).get("o");
        Path start = Path.of(pathSearch);
        List<Path> listPaths = Search.search(start, choosePredicate(searchType, fileName));
        writeFile(rslPath, listPaths);
    }

    private static Predicate<Path> choosePredicate(String type, String name) {
        Predicate<Path> condition = null;
        if (type.equals("name")) {
            condition = p -> p.toFile().getName().equals(name);
        }
        if (type.equals("mask")) {
            condition = p -> p.toFile().getName().endsWith(name);
        }
        if (type.equals("regex")) {
            condition = p -> p.toFile().getName().matches(name);
        }
        return condition;
    }

    private static void writeFile(String path, List<Path> list) {
        try (PrintWriter out = new PrintWriter(path, Charset.forName("UTF-8"))) {
            list.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
