package ru.job4j.collection.frog;

public class Matrix {
    private char[][] matrix = new char[16][10];

    public void createMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 'X';
            }
        }
    }

    public void drawMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setCell(int x, int y, char c) {
        matrix[x][y] = c;
    }
}
