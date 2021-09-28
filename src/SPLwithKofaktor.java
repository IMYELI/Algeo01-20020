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
        int newRow = matrix.length, newCol = matrix[0].length;
        float[][] matrixA = new float[newRow][newCol-1]; float[][] matrixB = new float[newRow][1];
        int row = matrixA.length, col = matrixA[0].length;
        float[][] temp = new float[row -1][col -1];
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
                System.out.format("X%i = %.2f  %n", (idxCol+1), x);
            }
        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}