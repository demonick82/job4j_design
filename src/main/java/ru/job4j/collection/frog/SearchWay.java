package ru.job4j.collection.frog;

import java.util.*;

public class SearchWay {
    private final Step start = new Step(11, 7);
    int stp = 1;


    public static void main(String[] args) {
        new SearchWay().searchWay();
    }

    public void searchWay() {
        int rsl = 0;
        Tree tree1 = new Tree(14, 9);
        Tree tree2 = new Tree(5, 8);
        Queue<Step> queue = new LinkedList();
        queue.add(start);
        while (!queue.isEmpty()) {
            Step step = queue.poll();
            if (step.getX() == 9 && step.getY() == 10) {
                System.out.println("Короткий путь найден " + rsl);
                break;
            }
            boolean isTree1 = step.getX() == tree1.getX() && step.getY() == tree1.getY();
            boolean isTree2 = step.getX() == tree2.getX() && tree2.getY() == step.getY();
            if ((step.getY() >= 1 && step.getY() <= 10 && !isTree2 && !isTree1)) {
                for (Step addStep : addSteps(step)) {
                    queue.add(addStep);
                    System.out.println(addStep);
                    rsl++;
                }
            }
        }
    }

    public List<Step> addSteps(Step step) {
        List<Step> list = new ArrayList<>();
        Step stepOne = new Step(step, 3, 0, 1, stp);
        Step stepTwo = new Step(step, 2, -1, 2, stp);
        Step stepThree = new Step(step, 2, 1, 3, stp);
        Step stepFour = new Step(step, 1, -2, 4, stp);
        Step stepFive = new Step(step, 1, 2, 5, stp);
        list.add(stepOne);
        list.add(stepTwo);
        list.add(stepThree);
        list.add(stepFour);
        list.add(stepFive);
        stp++;
        return list;
    }
}
