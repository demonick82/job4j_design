package ru.job4j.collection.statistics;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> currentMap = current.stream().
                collect(Collectors.toMap(User::getId, user -> user));

        int changed = 0;
        int deleted = 0;
        for (User prevUser : previous) {
            User currUser = currentMap.get(prevUser.getId());
            if (currUser == null) {
                deleted++;
            } else if (!currUser.equals(prevUser)) {
                changed++;
            }
        }
        int add = currentMap.size() - previous.size() + deleted;
        return new Info(add, changed, deleted);
    }
}
