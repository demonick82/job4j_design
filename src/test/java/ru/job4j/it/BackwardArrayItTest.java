package ru.job4j.it;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.NoSuchElementException;

public class BackwardArrayItTest {


    @Test
    public void whenMultiCallhasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
       assertThat(it.next(), is(3));
       assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenReadSequence2() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {2, 5, 7}
        );
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {}
        );
        it.next();
    }
}