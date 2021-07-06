package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(key))) {
            while (reader.ready()) {
                sb.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
