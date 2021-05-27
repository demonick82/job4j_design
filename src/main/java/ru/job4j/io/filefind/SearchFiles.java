package ru.job4j.io.filefind;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFiles implements FileVisitor<Path> {
    private Predicate<Path> condition;
    private List<Path> list = new ArrayList<>();
    private Pattern pattern;
    private Matcher matcher;


    public SearchFiles(Predicate<Path> condition) {
        this.condition = condition;
    }

    public SearchFiles(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        matcher = pattern.matcher(file.toFile().getName());
        if (matcher.find()) {
            list.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return list;
    }
}
