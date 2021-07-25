package Chapter1.src;

public class eight {
    public static void main(String[] args) throws Exception {

    }

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
}
