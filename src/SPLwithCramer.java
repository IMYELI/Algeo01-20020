public class SPLwithCramer {

    public static void SPLCramer(double[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix) - 1;

        double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int colA = OperasiMatrix.getCol(matrixA);
       
    
        if (OperasiMatrix.isSquare(matrixA)) {
            double determinan = determinanCramer.detKofaktor(matrixA);
            if (determinan != 0) {
                double[] HasilCramer = HasilSPL.HasilCramer(matrixA, matrixB, determinan);
                int idxCol;
                
                System.out.println("Solusinya sebagai berikut : ");
                for (idxCol = 0; idxCol < colA; idxCol++) {
                    System.out.printf("X%d = %.2f", (idxCol+1), HasilCramer[idxCol]);
                    System.out.println();
                }
            } else {
                System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain.");
            }
        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain.");
        }
    }
}