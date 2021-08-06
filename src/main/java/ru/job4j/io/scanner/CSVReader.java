package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {


    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader();
        csvReader.init(args);
    }

    private void init(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Не верно заданы параметры коммандной строки");
        }
        ArgsName argsName = ArgsName.of(args);
        String inFile = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String filter = argsName.get("filter");
        String outFile = argsName.get("out");
        writeFile(parseCSV(inFile, delimiter, findColumns(inFile, filter, delimiter)), outFile);
    }

    private List<String> parseCSV(String path, String delimiter, List<Integer> columns) throws FileNotFoundException {
        List<String> rsl = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().split(delimiter);
                StringJoiner joiner = new StringJoiner(delimiter);
                for (Integer column : columns) {
                    joiner.add(str[column]);
                }
                rsl.add(joiner.toString());
            }
        }
        return rsl;
    }

    private List<Integer> findColumns(String path, String filter, String lineSeparator) throws FileNotFoundException {
        List<Integer> rsl = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            String in = scanner.nextLine();
            String[] str = in.split(lineSeparator);
            String[] filters = filter.split(",");
            for (int i = 0; i < filters.length; i++) {
                for (int j = 0; j < str.length; j++) {
                    if (filters[i].equals(str[j])) {
                        rsl.add(j);
                    }
                }
            }
            return rsl;
        }
    }

    private void writeFile(List<String> in, String path) throws IOException {
        Path out = Paths.get(path);
        if (path.equals("stdout")) {
            in.forEach(System.out::println);
        } else {
            Files.write(out, in, StandardCharsets.UTF_8);
        }
    }
}
