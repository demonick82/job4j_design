package ru.job4j.io;

import java.io.FileOutputStream;

public class MultiTable {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(createTable().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String createTable() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                String out = String.format("%2d X %2d = %2d%5s", j, i, i * j, " ");
                builder.append(out);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
