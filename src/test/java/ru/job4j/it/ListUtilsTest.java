package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 1));
        Predicate<Integer> removeItem = f -> f == 1;
        ListUtils.removeIf(input, removeItem);
        assertThat(Arrays.asList(0, 2), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 1));
        Predicate<Integer> replaceItem = f -> f == 1;
        ListUtils.replaceIf(input, replaceItem, 6);
        assertThat(Arrays.asList(0, 6, 6, 2, 6), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 2, 3, 6));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 2));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1, 3, 6), Is.is(input));
    }
}