package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Sergey";
        byte age = 35;
        boolean sexIsMan = true;
        short weight = 90;
        int height = 170;
        long livingSpace = 50;
        float salary = 50000.656f;
        double credit = 220000.65;
        LOG.debug("User info name : {}, age : {}, sex is man : {}, weight : {}, height : {}, "
                        + "living space : {}, salary : {}, credit : {}", name, age, sexIsMan, weight,
                height, livingSpace, salary, credit);

    }
}
