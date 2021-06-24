package ru.job4j.collection.frog;

import java.util.Objects;

public class Step {
    private int x;
    private int y;
    private int number;
    private int step;

    public Step(Step step, int deltaX, int deltaY, int number, int stp) {
        x = step.getX() + deltaX;
        if (x > 16) {
            x = x - 16;
        }
        y = step.getY() + deltaY;
        this.number = number;
        this.step = stp;
    }

    public Step(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
                + " step" + step
                + '}';
    }
}
