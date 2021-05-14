package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;


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
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        assertThat(builder.toString(), is("10:57:01;10:59:01\r\n11:01:02;11:02:02\r\n"));
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenStopServerWithTmp() throws IOException {
        File source = folder.newFile("sourse.log");
        File target = folder.newFile("target.log");
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("200 10:56:01");
            writer.println("500 10:57:01");
            writer.println("400 10:58:01");
            writer.println("200 10:59:01");
            writer.println("500 11:01:02");
            writer.println("200 11:02:02");
        }
        Analysis analysis = new Analysis();
        analysis.unavailable(source.toString(), target.toString());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
                builder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(builder.toString(), is("10:57:01;10:59:01" + System.lineSeparator() + "11:01:02;11:02:02" + System.lineSeparator()));

    }
}