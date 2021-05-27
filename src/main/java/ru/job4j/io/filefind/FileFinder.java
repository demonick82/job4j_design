package ru.job4j.io.filefind;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.util.regex.Pattern;

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
        List<Path> listPaths = Search.searchRegex(start, choosePattern(searchType, fileName));
        writeFile(rslPath, listPaths);
    }

    private static Pattern choosePattern(String type, String name) {
        String strFileFind = switch (type) {
            case "name" -> strFileFind = "^" + name + "$";
            case "mask" -> strFileFind = name.replace("*", ".+").replace("?", ".{1}");
            case "regex" -> strFileFind = name;
            default -> throw new IllegalStateException("Неправильный ключ поиска" + name);
        };
        return Pattern.compile(strFileFind);
    }

    private static void writeFile(String path, List<Path> list) {
        try (PrintWriter out = new PrintWriter(path, Charset.forName("UTF-8"))) {
            list.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
