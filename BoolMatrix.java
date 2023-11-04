package kr8;

import java.util.Arrays;

public class BoolMatrix {
    private boolean[][] matrix;

    public BoolMatrix(int rows, int cols) {
        matrix = new boolean[rows][cols];
    }

    public void set(int row, int col, boolean value) {
        matrix[row][col] = value;
    }

    public boolean get(int row, int col) {
        return matrix[row][col];
    }

    public int getRows() {
        return matrix.length;
    }

    public int getCols() {
        if (matrix.length > 0) {
            return matrix[0].length;
        } else {
            return 0;
        }
    }

    public BoolMatrix logicalOr(BoolMatrix other) {
        int rows = getRows();
        int cols = getCols();
        BoolMatrix result = new BoolMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, this.get(i, j) || other.get(i, j));
            }
        }

        return result;
    }

    public BoolMatrix logicalAnd(BoolMatrix other) {
        int rows = getRows();
        int cols = getCols();
        BoolMatrix result = new BoolMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, this.get(i, j) && other.get(i, j));
            }
        }

        return result;
    }

    public BoolMatrix logicalNot() {
        int rows = getRows();
        int cols = getCols();
        BoolMatrix result = new BoolMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, !this.get(i, j));
            }
        }

        return result;
    }

    public int countOnes() {
        int count = 0;
        int rows = getRows();
        int cols = getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.get(i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public void sortRowsLexicographically() {
        Arrays.sort(matrix, (row1, row2) -> {
            String str1 = Arrays.toString(row1);
            String str2 = Arrays.toString(row2);
            return str1.compareTo(str2);
        });
    }

    public void printMatrix() {
        int rows = getRows();
        int cols = getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BoolMatrix matrix1 = new BoolMatrix(3, 3);
        BoolMatrix matrix2 = new BoolMatrix(3, 3);

        // Заповнюємо матриці
        matrix1.set(0, 0, true);
        matrix1.set(1, 1, true);
        matrix1.set(2, 2, true);

        matrix2.set(0, 1, true);
        matrix2.set(1, 2, true);
        matrix2.set(2, 0, true);

        // Виводимо матриці
        System.out.println("Матриця 1:");
        matrix1.printMatrix();
        System.out.println("Матриця 2:");
        matrix2.printMatrix();

        // Виконуємо операції над матрицями
        BoolMatrix orResult = matrix1.logicalOr(matrix2);
        System.out.println("Логічне додавання (диз'юнкція):");
        orResult.printMatrix();

        BoolMatrix andResult = matrix1.logicalAnd(matrix2);
        System.out.println("Логічне множення:");
        andResult.printMatrix();

        BoolMatrix notResult = matrix1.logicalNot();
        System.out.println("Логічна інверсія:");
        notResult.printMatrix();

        // Підраховуємо кількість одиниць
        int onesCount = matrix1.countOnes();
        System.out.println("Кількість одиниць в матриці 1: " + onesCount);

        // Впорядковуємо рядки лексикографічно
        matrix1.sortRowsLexicographically();
        System.out.println("Матриця 1 після впорядкування рядків:");
        matrix1.printMatrix();
    }
}
