public class SPLwithInvers {
    public static void SPLInvers(float[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix)-1;
        
        float[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        float[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int rowA = OperasiMatrix.getRow(matrixA), colA = OperasiMatrix.getCol(matrixA);
        int rowB = OperasiMatrix.getRow(matrixB), colB = OperasiMatrix.getCol(matrixB);
        

        if (OperasiMatrix.isSquare(matrixA) && colA == rowB) {
            boolean isNol = OperasiMatrix.isMatrixBNol(matrixB);
            float determinan = determinanCramer.detKofaktor(matrixA);
            //B matrix nol & determinan = 0
            if (isNol && determinan == 0) {
                System.out.println("Solusi tidak trivial, gunakan cara lain.");
            //B bukan matrix nol & determinan = 0
            } else if (!isNol && determinan == 0) {
                System.out.println("Solusi tidak tunggal unik, gunakan cara lain.");
            } else if (!isNol && determinan != 0) {
                    int idxRow;

                    float[][] matrixInversA = InversPakeAdjoin.InversAdjoin(matrixA, determinan);
                    float[][] matrixHasil = OperasiMatrix.mutiplyMatrix(matrixInversA, matrixB, rowA, colB);
                    int rowHasil = OperasiMatrix.getRow(matrixHasil), colHasil = OperasiMatrix.getCol(matrixHasil);

                    System.out.println("Solusinya sebagai berikut : ");
                    for (idxRow = 0; idxRow < rowHasil; idxRow++) {
                        System.out.format("X%o = %.2f", (idxRow + 1), matrixHasil[idxRow][colHasil-1]);
                        System.out.println();
                    }
            }
        //bukan matrix square tidak bisa invers
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}


