public class SPLwithGauss {
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

        matrixHasil = Gauss.gauss(matrix);
        col = matrixHasil[0].length;
        row = matrix.length;

        for (idx = 0; idx < col - 1; idx++) {
            if (matrixHasil[row-1][idx] != 0) {
                isAllNol = false;
            }
        }
        if (isAllNol) {
            solusi = 2;
        }

        if (solusi == 1) {
            float solusiX[] = new float[row];
            int idxUnik, idxHasilUnik;

            for (idxUnik = row - 1; idxUnik >= 0; idxUnik--) {
                solusiX[idxUnik] = matrixHasil[idxUnik][col];
                int idxSol;
                for (idxSol = idxUnik + 1; idxSol < col; idxSol++) {
                    solusiX[idxUnik] -= matrixHasil[idxUnik][idxSol] * solusiX[idxSol];
                }
            }
            int pnjgSol = solusiX.length;
            for (idxHasilUnik = colSol - 1; idxHasilUnik >= 0; idxHasilUnik--) {
                int n = colSol - idxHasilUnik;
                System.out.format("X%i = %.2f %n", n, solusiX[idxHasilUnik]);
            }

        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");

        } /* else {
            int lengthMany = 0, idxBanyak, rowBanyak, colBanyak;
            char solusiBanyak[] = new char[col];
            char solBanyak = 's';

            for (idxBanyak = row - 1; idxBanyak >= -; idxBanyak--) {
                if (isRowManySolution(matrixHasil[idxBanyak]) {
                    int idxSol;
                    for (idxSol = idxBanyak + 1; idxSol < col; idxSol++) {
                        solusiBanyak[idxBanyak] -= matrixHasil[idxBanyak][idxSol] * solusiX[idxSol];
                    }
            }




            for (rowBanyak = 0; rowBanyak < row; rowBanyak++) {
                for (colBanyak = 0; colBanyak < col; colBanyak) {

                }
            }

        } */

    }


}
