package ru.job4j.io;
import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("even.txt")) {
            StringBuilder builder = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                builder.append((char) read);
            }
            String[] str = builder.toString().split(System.lineSeparator());
            for (String s : str) {
                if (Integer.parseInt(s) % 2 != 0) {
                    System.out.printf("Число %s - нечетное%n", s);
                } else {
                    System.out.printf("Число %s - четное%n", s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
