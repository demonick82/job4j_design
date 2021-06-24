package ru.job4j.collection.frog;

import java.util.Objects;

public class Tree {
    private int x;
    private int y;

    public Tree(int x, int y) {
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
        Tree tree = (Tree) o;
        return x == tree.x
                && y == tree.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Tree{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }
}
