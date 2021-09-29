public class SPLwithKofaktor {

    public static float[][] changeCol(float[][] matrixA, float[][] matrixB, int col) {
        int row = matrixA.length, idxRow;

        for (idxRow = 0; idxRow < row; idxRow++) {
            matrixA[idxRow][col] = matrixB[idxRow][0];
        }
        return matrixA;
    }

    public static void SPLKofaktor(float[][] matrix) {
        boolean isSquare = true;
        int newRow = matrix.length, newCol = matrix[0].length - 1;

        float[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        float[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int row = matrixA.length, col = matrixA[0].length;
        float[][] temp = BacaTulisMatrix.copy(matrixA);
        float determinan;

        if (row != col) {
            isSquare = false;
        }
        determinan = determinanCramer.detKofaktor(matrixA);
    
        if (isSquare) {
            int idxCol;

            for (idxCol = 0; idxCol < col; idxCol++) {
                temp = changeCol(matrixA, matrixB, idxCol);
                float detTemp = determinanCramer.detKofaktor(temp);
                float x = detTemp/determinan;
                System.out.format("X%o = %.2f  %n", (idxCol+1), x);
                temp = BacaTulisMatrix.copy(matrixA);
            }
        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}