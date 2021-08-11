package Chapter1;

public class ArrayHelpers {
    public static boolean matrixEqual(int[][] mat1, int[][] mat2) {
        if (mat1.length != mat2.length) {
            return false;
        }

        for (int row = 0; row < mat1.length; row++) {
            if (mat1[row].length != mat2[row].length)
                return false;
            for (int col = 0; col < mat2.length; col++) {
                if (mat1[row][col] != mat2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
