package ru.job4j.template;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorTest {
    @Test
    public void keysExists() {
        Generator generator = new TempGenerator();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Petr Arsentev", "subject", "you");
        assertThat(generator.produce(temp, keys), is("I am a Petr Arsentev, Who are you?"));
    }

    @Test(expected = Exception.class)
    public void keysNotExistsMap() {
        Generator generator = new TempGenerator();
        String temp = "I am a ${age}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Petr Arsentev", "subject", "you");
        assertThat(generator.produce(temp, keys), is("I am a Petr Arsentev, Who are you?"));
    }

    @Test(expected = Exception.class)
    public void extraKeys() {
        Generator generator = new TempGenerator();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Petr Arsentev", "subject", "you",
                "age", "Dmitriy", "surname", "you");
        assertThat(generator.produce(temp, keys), is("I am a Petr Arsentev, Who are you?"));
    }
}