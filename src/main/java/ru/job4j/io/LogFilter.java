package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        String regex = "404.\\d+";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (findMatcher(regex, line)) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean findMatcher(String pattern, String line) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        return m.find();
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}

