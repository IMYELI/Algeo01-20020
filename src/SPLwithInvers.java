public class SPLwithInvers {
    public static double[] SPLInvers(double[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix)-1;
        double[] mPalingHasil = new double[matrix.length];
        double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int rowA = OperasiMatrix.getRow(matrixA), colA = OperasiMatrix.getCol(matrixA);
        int rowB = OperasiMatrix.getRow(matrixB), colB = OperasiMatrix.getCol(matrixB);
        

        if (OperasiMatrix.isSquare(matrixA) && colA == rowB) {
            boolean isNol = OperasiMatrix.isMatrixBNol(matrixB);
            double determinan = determinanCramer.detKofaktor(matrixA);
            //B matrix nol & determinan = 0
            if (isNol && determinan == 0) {
                System.out.println("Solusi tidak trivial, gunakan cara lain.");
            //B bukan matrix nol & determinan = 0
            } else if (!isNol && determinan == 0) {
                System.out.println("Solusi tidak tunggal unik, gunakan cara lain.");
            } else if (!isNol && determinan != 0) {

                    double[][] matrixInversA = InversPakeAdjoin.InversAdjoin(matrixA, determinan);
                    double[][] matrixHasil = OperasiMatrix.mutiplyMatrix(matrixInversA, matrixB, rowA, colB);
                    mPalingHasil = convert1D(matrixHasil);
                    // tulis(matrixHasil);
                    
            }
        //bukan matrix square tidak bisa invers
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
        return mPalingHasil;
    }
    public static void tulis(double[][] matrixHasil){
        int idxRow;
        int rowHasil = OperasiMatrix.getRow(matrixHasil), colHasil = OperasiMatrix.getCol(matrixHasil);    
        System.out.println("Solusinya sebagai berikut : ");
        for (idxRow = 0; idxRow < rowHasil; idxRow++) {
            System.out.format("X%o = %.2f", (idxRow + 1), matrixHasil[idxRow][colHasil-1]);
            System.out.println();
        }
    }
    public static double[] convert1D(double[][] matrixHasil){
        int i;
        double[] mat1D = new double[matrixHasil.length];
        for(i=0;i<matrixHasil.length;i++){
            mat1D[i] = matrixHasil[i][0];
        }
        return mat1D;
    }
}


