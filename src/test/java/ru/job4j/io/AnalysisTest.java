package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalysisTest {
    @Test
    public void whenStopServer() {
        String input = "./data/server.log";
        String output = "./data/unavailable.log";
        Analysis analysis = new Analysis();
        analysis.unavailable(input, output);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
                builder.append(System.lineSeparator());
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        ;
        assertThat(builder.toString(), is("10:57:01;10:59:01\r\n11:01:02;11:02:02\r\n"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBadData() {
        String input = "./data/server_bad.log";
        String output = "./data/unavailable.log";
        Analysis analysis = new Analysis();
        analysis.unavailable(input, output);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
                builder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        assertThat(builder.toString(), is("10:57:01;10:59:01\r\n11:01:02;11:02:02\r\n"));
    }

}