package dr6;

public class task2_10 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        int maxElement = matrix[0][0];
        int maxRow = 0;
        int maxColumn = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }


        int[][] newMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        int newRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i == maxRow) {
                continue;
            }

            int newColumn = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == maxColumn) {
                    continue;
                }

                newMatrix[newRow][newColumn] = matrix[i][j];
                newColumn++;
            }

            newRow++;
        }


        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}