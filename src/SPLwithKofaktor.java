public class SPLwithKofaktor {

    public static float[][] changeCol(float[][] matrixA, float[] matrixB, int col) {
        int row = matrixA.length, idxRow;

        for (idxRow = 0; idxRow < row; idxRow++) {
            matrixA[idxRow][col] = matrixB[idxRow];
        }
        return matrixA;
    }

    public static void SPLKofaktor(float[][] matrixA, float[] matrixB) {
        boolean isSquare = true;
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

            }
            
            

        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}