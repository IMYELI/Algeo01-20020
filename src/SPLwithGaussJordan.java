public class SPLwithGaussJordan {

    public static void SPLGaussJordan(double[][] matrix) {
        int row = OperasiMatrix.getRow(matrix), col = OperasiMatrix.getCol(matrix);

        double[][] matrixHasil = Gauss.jordan(matrix);
        double[][] matrixCekSolusi = matrixHasil;

        int solusi = 1;

        int firstLower = OperasiMatrix.idxRowNotNol(matrixCekSolusi);

        if (OperasiMatrix.isNotSolution(matrixCekSolusi)) {
            solusi = 2;
        } else if (OperasiMatrix.isAllNol(matrixCekSolusi, firstLower)) {
            solusi = 3;
        }

        if (solusi == 1) {
            double solusiX[] = HasilSPL.HasilUnikJordan(matrixHasil);

            
            System.out.println("Solusinya sebagai berikut : ");

            int idxCol;
            for (idxCol = 0; idxCol < col - 1; idxCol++) {
                System.out.format("X%d = %.2f %n", (idxCol+1), solusiX[idxCol]);
            }
        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");
        } else if (solusi == 3) {
            String[] solusiX = HasilSPL.HasilGakUnik(matrixHasil);

            System.out.println("Solusinya sebagai berikut : ");

            int idxCol;
            for (idxCol = 0; idxCol < col - 1; idxCol++) {
                System.out.format("X%d = %s %n", (idxCol+1), solusiX[idxCol]);
            }
        }
    }
}

