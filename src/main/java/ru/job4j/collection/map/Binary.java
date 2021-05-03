package ru.job4j.collection.map;

import java.util.HashMap;
import java.util.Map;

public class Binary {
    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Binary.binary(123124));
        System.out.println(Binary.binary(123 >>> 4));
        Map<String, String> map = new HashMap<>();

    }
}
