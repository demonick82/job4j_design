package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> botAnswersList = new ArrayList<>();
    private Random rnd = new Random();
    private boolean stopServer = false;


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (PrintWriter out = new PrintWriter(path, Charset.forName("UTF-8"))) {
            createList(botAnswers);
            Scanner s = new Scanner(System.in);
            String question;
            do {
                question = s.nextLine();
                if (question.equals(STOP)) {
                    stopServer = true;
                }
                if (question.equals(CONTINUE)) {
                    stopServer = false;
                }
                out.println(question);
                if (!stopServer && !question.equals(OUT)) {
                    out.println(botAnswersList.get(rnd.nextInt(botAnswersList.size())));
                }
            } while (!question.equals(OUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createList(String botAnswers) {
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            while (reader.ready()) {
                botAnswersList.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/dialog.log", "./data/botAnswers.log");
        cc.run();
    }
}
