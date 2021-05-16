package ru.job4j.collection.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void when1Add2Changed2Deleted() {
        List<User> previous = new ArrayList<>(List.of(new User(1, "Dmitriy"), new User(2, "Olga"),
                new User(3, "Sergey"), new User(4, "Tatiana"), new User(6, "Aleksandr")));
        List<User> current = new ArrayList<>(List.of(new User(1, "Dmitriy"), new User(2, "Ekaterina"),
                new User(3, "Grigoriy"), new User(5, "Andrey")));
        Analize analize = new Analize();
        Info excepted = new Info(1, 2, 2);
        assertThat(excepted, is(analize.diff(previous, current)));
    }
}