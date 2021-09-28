public class SPLwithGaussJordan {
    public static boolean isRowManySolution(float[] row) {
        int col = 0;
        boolean isManySolution = true;

        while (isManySolution && col < row.length) {
            if (row[col] != 0) {
                isManySolution = false;
            } else {
                col++;
            }
        }
        return isManySolution;
    }

    public static float[][] SPLGaussJordan(float[][] matrix) {
        float[][] matrixHasil;
        int solusi = 1, idx, row, col;
        boolean isAllNol = true, isSquare = true;

        matrixHasil = Gauss.jordan(matrix);
        col = matrixHasil[0].length;
        row = matrix.length;

        if (row != col - 1) {
            isSquare = false;
        }

        for (idx = 0; idx < col - 1; idx++) {
            if (matrixHasil[row-1][idx] != 0) {
                isAllNol = false;
            }
        }
        if (isAllNol) {
            solusi = 2;
        } else if (isSquare) {
            solusi = 3;
        }

        if (solusi == 1) {
            float solusiX[] = new float[col-2];

            for (idx = row - 1; idx >= 0; idx--) {
                solusiX[idx] = matrixHasil[idx][row];
            }
            int colSol = solusiX.length;
            for (idx = colSol - 1; idx >= 0; idx++) {
                int n = colSol - idx + 1;
                System.out.format("X%i = %.2f %n", n, solusiX[idx]);
            }
        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");
        } /* else {

        } */
        return matrix;
    }
}
