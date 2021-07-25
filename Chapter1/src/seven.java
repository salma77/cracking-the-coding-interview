package Chapter1.src;

public class seven {
    public static void main(String[] args) throws Exception {

        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        rotate(matrix);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }

    public static void rotate(int matrix[][]) {
        int n = matrix.length;
        for (int frame = 0; frame < n / 2; frame++) {
            for (int i = frame; i < n - frame - 1; i++) {
                // swapping process
                int temp = matrix[frame][i]; // saving the first element
                matrix[frame][i] = matrix[n - 1 - i][frame];
                matrix[n - 1 - i][frame] = matrix[n - frame - 1][n - 1 - i];
                matrix[n - frame - 1][n - 1 - i] = temp;
            }
        }
    }
}
