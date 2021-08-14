package Chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysAndStrings {
    /**
     * The function iterates through the string, copying characters to a new string
     * and counting the character repeats, check if the current character is the
     * same as the next character. If not, add its compressed version to the result.
     * 
     * @param str the string to be compressed
     * @return
     */
    public static String compressString(String str) {
        int consecutive = 0;
        String compressed_str = "";
        for (int i = 0; i < str.length(); i++) {
            consecutive++;
            if (i + 1 == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed_str += "" + str.charAt(i) + consecutive;
                consecutive = 0;
            }
        }
        return compressed_str.length() > str.length() ? str : compressed_str;
    }

    @Test
    public void testCompressString() {
        assertEquals(compressString("aabbbcdhhhhhhl"), "a2b3c1d1h6l1");
        assertEquals(compressString("a"), "a");
        assertEquals(compressString("ss"), "s2");
        assertEquals(compressString(""), "");
    }

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
        int temp;
        for (int frame = 0; frame < n / 2; frame++) {
            int first = frame;
            int last = n - 1 - frame;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                temp = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }
    }

    @Test
    public void testRotateMatrix() {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        int[][] rotated_matrix = { { 21, 16, 11, 6, 1 }, { 22, 17, 12, 7, 2 }, { 23, 18, 13, 8, 3 },
                { 24, 19, 14, 9, 4 }, { 25, 20, 15, 10, 5 } };
        rotateMatrix(matrix);
        assertTrue(ArrayHelpers.matrixEqual(matrix, rotated_matrix));
    }

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
        int[][] edited_matrix = { { 0, 0, 0, 0, 0 }, { 6, 7, 0, 9, 0 }, { 11, 12, 0, 14, 0 }, { 16, 17, 0, 19, 0 },
                { 0, 0, 0, 0, 0 } };
        boolean[] rows = new boolean[5];
        boolean[] cols = new boolean[5];
        getZeroIndices(matrix, rows, cols);
        editMatrix(matrix, rows, cols);
        assertTrue(ArrayHelpers.matrixEqual(matrix, edited_matrix));
    }

    /**
     * Function that checks whether a string s1 is a rotation of s2
     * 
     * @param str1 first string
     * @param str2 second string
     * @return true, if s2 is a rotation of s1
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length())
            return isSubstring(s1 + s1, s2);
        return false;
    }

    static boolean isSubstring(String s1, String s2) {
        String combined_str = s1 + s1;
        return combined_str.contains(s2);
    }

    @Test
    public void testIsRotation() {
        assertTrue(isRotation("waterbottle", "erbottlewat"));
        assertFalse(isRotation("salmaaa", "sthelse"));
    }
}
