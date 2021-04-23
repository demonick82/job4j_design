package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        User user1 = new User("Sasha", 1, new GregorianCalendar(1979, 1, 25));
        User user2 = new User("Sasha", 1, new GregorianCalendar(1979, 1, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        for (User user : map.keySet()) {
            System.out.println(user);
        }

    }
}
