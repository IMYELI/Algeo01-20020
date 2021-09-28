public class SPLwithGaussJordan {
    public  static boolean isRowManySolution(float[] row) {
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

    public static void SPLGauss(float[][] matrix) {
        float[][] matrixHasil;
        int solusi = 1, idx, row, col;
        boolean isAllNol = true;

        matrixHasil = Gauss.jordan(matrix);
        col = matrixHasil[0].length;
        row = matrix.length;

        if (row != col - 1) {
            solusi = 3
        }

        for (idx = 0; idx < col - 1; idx++) {
            if (matrixHasil[row-1][idx] != 0) {
                isAllNol = false;
            }
        }
        if (isAllNol) {
            solusi = 2;
        }
        if (solusi == 1) {
            float solusiX[] = new float[col];

            for (idx = row - 1; idx >= 0; idx--) {
                solusiX[idx] = matrixHasil[idx][row];
            }
            int colSol = solusiX.length;
            for (idx = colSol - 1; idx >= 0; idx++) {
                int n = colSol - idx;
                System.out.format("X%i = %.2f %n", idx, solusiX[idx]);
            }
        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");
        } /* else {

        } */

    }


}
