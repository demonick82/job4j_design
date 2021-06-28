package ru.job4j.collection.frog;

import java.util.*;

public class SearchWay {
    private final Step start = new Step(11, 7);
    private final Step finish = new Step(9, 10);
    private final Tree tree1 = new Tree(14, 9);
    private final Tree tree2 = new Tree(5, 8);
    private Matrix matrix = new Matrix();
    private Set<Integer> steps = new LinkedHashSet<>();

    SearchWay() {
        matrix.createMatrix();
        matrix.setCell(start.getX() - 1, start.getY() - 1, '*');
        matrix.setCell(finish.getX() - 1, finish.getY() - 1, 'F');
        matrix.setCell(tree1.getX() - 1, tree1.getY() - 1, 'T');
        matrix.setCell(tree2.getX() - 1, tree2.getY() - 1, 'T');
    }

    public static void main(String[] args) {
        new SearchWay().searchWay();

    }

    public void searchWay() {
        int rsl = 0;
        Queue<Step> queue = new LinkedList();
        queue.add(start);

        while (!queue.isEmpty()) {
            rsl++;
            Step step = queue.poll();
            matrix.setCell(step.getX() - 1, step.getY() - 1, 'S');
            matrix.drawMatrix();
            if (step.getX() == 9 && step.getY() == 10) {
                System.out.println("Короткий путь найден число шагов=" + steps.size());
                break;
            }
            int minStep = addSteps(step).get(0).getMinStep();
            steps.add(minStep);
            for (Step addStep : addSteps(step)) {
                boolean isTree1 = addStep.getX() == tree1.getX() && addStep.getY() == tree1.getY();
                boolean isTree2 = addStep.getX() == tree2.getX() && tree2.getY() == addStep.getY();
                if ((addStep.getY() >= 1 && addStep.getY() <= 10 && !isTree1 && !isTree2)) {
                    if (addStep.getMinStep() == minStep) {
                        queue.add(addStep);
                    }
                }
            }
        }
    }

    int shortDistance(Step current, Step finish) {
        int x;
        if (current.getX() > finish.getX()) {
            x = 16 - Math.abs(current.getX() - finish.getX());
        } else {
            x = Math.abs(current.getX() - finish.getX());
        }
        int y = Math.abs(current.getY() - finish.getY());
        return x + y;
    }

    public List<Step> addSteps(Step step) {
        List<Step> list = new ArrayList<>();
        Step stepOne = new Step(step, 3, 0, 1);
        Step stepTwo = new Step(step, 2, -1, 2);
        Step stepThree = new Step(step, 2, 1, 3);
        Step stepFour = new Step(step, 1, -2, 4);
        Step stepFive = new Step(step, 1, 2, 5);
        stepOne.setMinStep(shortDistance(stepOne, finish));
        stepTwo.setMinStep(shortDistance(stepTwo, finish));
        stepThree.setMinStep(shortDistance(stepThree, finish));
        stepFour.setMinStep(shortDistance(stepFour, finish));
        stepFive.setMinStep(shortDistance(stepFive, finish));
        list.add(stepOne);
        list.add(stepTwo);
        list.add(stepThree);
        list.add(stepFour);
        list.add(stepFive);
        Collections.sort(list);
        return list;
    }
}
