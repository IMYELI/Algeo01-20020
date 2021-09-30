public class SPLwithGauss {
    public static void SPLGauss(double[][] matrix) {
        int row = OperasiMatrix.getRow(matrix), col = OperasiMatrix.getCol(matrix);

        double[][] matrixHasil = Gauss.jordan(matrix);
        double[][] matrixCekSolusi = matrixHasil;
        double[][] matrixCek = OperasiMatrix.makeMatrixA(matrixHasil, row, col-1);

        int solusi = 1;

        if (OperasiMatrix.isNotSolution(matrixCekSolusi)) {
            solusi = 2;
        } else if (!(OperasiMatrix.isSquare(matrixCek)) || OperasiMatrix.isAllNol(matrixCekSolusi, row -1)) {
            solusi = 3;
        }

        if (solusi == 1) {
            double solusiX[] = HasilSPL.HasilUnikGauss(matrixHasil);
            
            System.out.println("Solusinya sebagai berikut : ");

            int idxCol;           
            for (idxCol = 0; idxCol < col - 1; idxCol++) {
                System.out.format("X%o = %.2f %n", (idxCol+1), solusiX[idxCol]);
            }
        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");
        }  else if (solusi == 3) {
            String[] solusiX = HasilSPL.HasilGakUnik(matrixHasil);
            
            System.out.println("Solusinya sebagai berikut : ");

            int idxCol;
            for (idxCol = 0; idxCol < col - 1; idxCol++) {
                System.out.format("X%o = %s %n", (idxCol+1), solusiX[idxCol]);
            }
        }
    }
}    
