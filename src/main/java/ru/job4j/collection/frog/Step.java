package ru.job4j.collection.frog;

import java.util.Objects;

public class Step implements Comparable<Step> {
    private int x;
    private int y;
    private int number;
    private int minStep;


    public Step(Step step, int deltaX, int deltaY, int number) {
        x = step.getX() + deltaX;
        if (x > 16) {
            x = x - 16;
        }
        y = step.getY() + deltaY;
        this.number = number;
    }


    public Step(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMinStep(int minStep) {
        this.minStep = minStep;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMinStep() {
        return minStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Step step = (Step) o;
        return x == step.x
                && y == step.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Step{"
                + "x=" + x
                + ", y=" + y
                + " ,n" + number
                + " ,minDist" + minStep

                + '}';
    }


    @Override
    public int compareTo(Step o) {
        if (this.minStep == o.minStep) {
            return 1;
        }
        return this.minStep - o.minStep;
    }
}
