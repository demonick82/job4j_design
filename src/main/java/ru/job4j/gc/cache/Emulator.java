package ru.job4j.gc.cache;

import java.io.File;
import java.util.Scanner;

public class Emulator {
    private String path;
    private DirFileCache dirFileCache;
    private Scanner in = new Scanner(System.in);


    public void menu() {
        System.out.println("1. Укажите кэшируемую директорию");
        System.out.println("2. Загрузить содержимое файла в кэш");
        System.out.println("3. Получить содержимое файла из кэша");
        System.out.println("4. Выход");
    }

    public void start() {
        boolean run = true;
        while (run) {
            int menu = Integer.parseInt(in.nextLine());
            switch (menu) {
                case 1:
                    setDirectory();
                    break;
                case 2:
                    putCache();
                    break;
                case 3:
                    getCash();
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Введите число от 1 до 4");
            }
        }
    }

    private void setDirectory() {
        System.out.println("Укажите директорию");
        path = in.nextLine();
        System.out.println("Успешно выполнено");
        menu();
    }

    private void putCache() {
        dirFileCache = new DirFileCache(path);
        File folder = new File(dirFileCache.getCachingDir());
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String res = dirFileCache.load(file.getAbsolutePath());
                    dirFileCache.put(file.getName(), res);
                }
            }
            System.out.println("Успешно выполнено");
            menu();
        } else {
            System.out.println("Данной директории не существует");
            menu();
        }
    }

    private void getCash() {
        System.out.println(dirFileCache.get(in.nextLine()));
        System.out.println("Успешно выполнено");
        menu();
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.menu();
        emulator.start();
    }
}
