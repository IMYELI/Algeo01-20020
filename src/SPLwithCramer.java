public class SPLwithCramer {

    public static void SPLCramer(double[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix) - 1;

        double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);
        double[][] temp = BacaTulisMatrix.copy(matrixA);

        int colA = OperasiMatrix.getCol(matrixA);
        double determinan = determinanCramer.detKofaktor(matrixA);
    
        if (OperasiMatrix.isSquare(matrixA) && determinan != 0) {
            int idxCol;
            System.out.println("Solusinya sebagai berikut : ");
            for (idxCol = 0; idxCol < colA; idxCol++) {
                OperasiMatrix.changeCol(temp, matrixB, idxCol);
                double detTemp = determinanCramer.detKofaktor(temp);
                double x = detTemp/determinan;
                System.out.format("X%o = %.2f", (idxCol+1), x);
                System.out.println();
                temp = BacaTulisMatrix.copy(matrixA);
            }
        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain.");
        }
    }
}