package Chapter1.src;

import org.junit.Test;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 */

public class ZeroMatrix {
    /**
     * This function finds the elements which equal zero, and sets the corresponding
     * index of row array and column array
     * 
     * @param matrix the matrix we want to get its zero indices
     * @param rows   an array of rows initiated to false
     * @param cols   an array of columns initiated to false
     */
    public static void getZeroIndices(int matrix[][], boolean rows[], boolean cols[]) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
    }

    public static void editMatrix(int matrix[][], boolean rows[], boolean cols[]) {
        for (int i = 0; i < rows.length; i++) {
            if (rows[i])
                for (int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
        }
        for (int j = 0; j < cols.length; j++) {
            if (cols[j])
                for (int i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;
        }

    }

    @Test
    public void testEditMatrix() {
        int[][] matrix = { { 1, 2, 0, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 0 } };
        boolean[] rows = new boolean[5];
        boolean[] cols = new boolean[5];
        getZeroIndices(matrix, rows, cols);
        editMatrix(matrix, rows, cols);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
