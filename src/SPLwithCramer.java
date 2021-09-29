public class SPLwithCramer {

    public static void SPLCramer(double[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix) - 1;

        double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int colA = OperasiMatrix.getCol(matrixA);
        double determinan = determinanCramer.detKofaktor(matrixA);
    
        if (OperasiMatrix.isSquare(matrixA) && determinan != 0) {
            double[] HasilCramer = HasilSPL.HasilCramer(matrixA, matrixB, determinan);
            int idxCol;
            
            System.out.println("Solusinya sebagai berikut : ");
            for (idxCol = 0; idxCol < colA; idxCol++) {
                System.out.format("X%o = %.2f", (idxCol+1), HasilCramer[idxCol]);
                System.out.println();
            }
        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain.");
        }
    }
}