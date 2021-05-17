package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.normalize().toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.normalize().toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Неверно заданы параметры коммандной строки");
        }
        String firstArg = ArgsName.of(args).get("d");
        String secondArg = ArgsName.of(args).get("e");
        String thirdArg = ArgsName.of(args).get("o");
        Path start = Paths.get(firstArg);
        Predicate<Path> predicate = p -> !p.toFile().getName().endsWith(secondArg);
        new Zip().packFiles(Search.search(start, predicate), new File(thirdArg));
    }
}
