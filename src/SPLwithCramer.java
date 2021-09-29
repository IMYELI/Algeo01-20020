public class SPLwithCramer {

    public static void SPLCramer(float[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix) - 1;

        float[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        float[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);
        float[][] temp = BacaTulisMatrix.copy(matrixA);

        int colA = OperasiMatrix.getCol(matrixA);
        float determinan = determinanCramer.detKofaktor(matrixA);
    
        if (OperasiMatrix.isSquare(matrixA)) {
            int idxCol;

            for (idxCol = 0; idxCol < colA; idxCol++) {
                OperasiMatrix.changeCol(temp, matrixB, idxCol);
                float detTemp = determinanCramer.detKofaktor(temp);
                float x = detTemp/determinan;
                System.out.format("X%o = %.2f", (idxCol+1), x);
                System.out.println();
                temp = BacaTulisMatrix.copy(matrixA);
            }
        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}