package ru.job4j.collection.frog;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchWayTest {
    @Test
    public void testShortDist() {
        SearchWay searchWay = new SearchWay();
        Step step = new Step(1, 7);
        Step step1 = new Step(9, 10);
        //searchWay.shortDistance(step, step1);
        System.out.println(searchWay.shortDistance(step, step1));

    }

}