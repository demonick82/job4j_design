package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analysis {
    private String bugStart;
    private String bugFinish;
    private Map<String, String> serverStop = new HashMap<>();
    private int lastStatus = 0;

    public void unavailable(String source, String target) {
        readServerStatus(source);
        writeServerStatus(target);
    }

    private void readServerStatus(String path) {
        int status;
        String date;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] splitLine = line.split(" ");
                if (splitLine.length != 2) {
                    throw new IllegalArgumentException("Неверный формат файла!!");
                }
                status = Integer.parseInt(splitLine[0]);
                date = splitLine[1];
                if ((status == 500 || status == 400) && lastStatus != 500) {
                    bugStart = date;
                    lastStatus = 500;
                }
                if ((status == 200 || status == 300) && (lastStatus == 500)) {
                    bugFinish = date;
                    serverStop.put(bugStart, bugFinish);
                    lastStatus = 200;
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeServerStatus(String path) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {
            for (Map.Entry<String, String> line : serverStop.entrySet()) {
                writer.printf("%s;%s%n", line.getKey(), line.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log", "./data/unavailable.log");



/*        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
