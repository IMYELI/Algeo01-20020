public class SPLwithInvers {
    public static void SPLInvers(float[][] matrix) {
        int newRow = matrix.length, newCol = matrix[0].length-1;
        
        float[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        float[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int rowA = OperasiMatrix.getRow(matrixA), colA = OperasiMatrix.getCol(matrixA);
        int rowB = OperasiMatrix.getRow(matrixB), colB = OperasiMatrix.getCol(matrixB);
        

        if (OperasiMatrix.isSquare(matrixA) && colA == rowB) {
            boolean isNol = OperasiMatrix.isMatrixBNol(matrixB);
            float determinan = determinanCramer.detKofaktor(matrixA);
            //B matrix nol
            if (isNol) {
                //Determinan = 0
                if (determinan == 0) {
                    System.out.println("Solusi tidak trivial, gunakan cara lain.");
                } else {
                    int idx;
                    System.out.println("Solusinya sebagai berikut : ");
                    for (idx = 0; idx < colA; idx++) {
                        int n = idx + 1;
                        System.out.format("X%o = 0", n);
                        System.out.println();
                    }
                }
            //B bukan matrix nol
            } else {
                //Determinan = 0
                if (determinan == 0) {
                    System.out.println("Solusi tidak tunggal unik, gunakan cara lain.");
                } else {
                    int idxRow, idxCol;

                    float[][] matrixInversA = InversPakeAdjoin.InversAdjoin(matrixA, determinan);
                    float[][] matrixHasil = OperasiMatrix.mutiplyMatrix(matrixInversA, matrixB, rowA, colB);
                    int rowHasil = OperasiMatrix.getRow(matrixHasil), colHasil = OperasiMatrix.getCol(matrixHasil);

                    System.out.println("Solusinya sebagai berikut : ");
                    for (idxRow = 0; idxRow < rowHasil; idxRow++) {
                        for (idxCol = 0 ; idxCol < colHasil; idxCol++) {
                            System.out.format("X%o = %.2f", (idxRow + 1), matrixHasil[idxRow][idxCol]);
                            System.out.println();
                        }  
                    }
                }
            }
        //bukan matrix square tidak bisa invers
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}
