package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {
    @Test
    public void whenAddInMap() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.insert(1, 6);
        assertThat(map.get(1), is(6));
    }

    @Test
    public void whenAddInMapDuplicateKey() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.insert(1, 6);
        map.insert(1, 7);
        assertThat(map.get(1), is(7));
    }

    @Test
    public void whenDeleteInMap() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.insert(1, 6);
        map.insert(2, 7);
        map.delete(1);
        assertThat(map.get(2), is(7));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCrashIterator() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.insert(1, 6);
        map.insert(2, 7);
        Iterator<SimpleMap.Node<Integer, Integer>> iterator = map.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            map.insert(3, 9);
        }
    }

}