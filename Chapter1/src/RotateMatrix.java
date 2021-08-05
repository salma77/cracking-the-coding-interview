package Chapter1.src;

import org.junit.Test;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 */
public class RotateMatrix {
    /**
     * This method rotates a matrix by 90 degrees, it divides the matrix into frames
     * inside each other. It performs the rotation by swapping the upper edge of the
     * frame to be the right edge, and the right edge to be the lower edge, and so
     * on.
     * 
     * @param matrix the martix to be rotated
     */

    public static void rotateMatrix(int matrix[][]) {
        int n = matrix.length;
        for (int frame = 0; frame < n / 2; frame++) {
            int last = n - 1 - frame;
            for (int i = frame; i < n - frame - 1; i++) {
                int offset = i - frame;
                // Swapping process
                int temp = matrix[frame][i];
                matrix[frame][i] = matrix[last - offset][frame];
                matrix[last - offset][frame] = matrix[last][last - offset];
                matrix[last][last - offset] = temp;
            }
        }
    }

    @Test
    public void testRotateMatrix() {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        rotateMatrix(matrix);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
