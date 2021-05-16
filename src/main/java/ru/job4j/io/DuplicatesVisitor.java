package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private List<FileProperty> list = new ArrayList<>();
    private Set<FileProperty> set = new HashSet<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.getFileName().toString();
        long fileSize = Files.size(file);
        FileProperty property = new FileProperty(fileSize, fileName);
        if (!set.add(property)) {
            list.add(property);
        }
        return super.visitFile(file, attrs);
    }

    public List<FileProperty> getPaths() {
        return list;
    }
}
