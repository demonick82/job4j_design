package ru.job4j.collection.statistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> currentMap = current.stream().
                collect(Collectors.toMap(User::getId, User::getName));
        int changed = 0;
        int deleted = 0;
        for (User user : previous) {
            if ((currentMap.containsKey(user.getId())) && !currentMap.containsValue(user.getName())) {
                changed++;
            } else if (!currentMap.containsKey(user.getId())) {
                deleted++;
            }
        }
        int add = currentMap.size() - previous.size() + deleted;
        return new Info(add, changed, deleted);
    }
}
