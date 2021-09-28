public class SPLwithInvers {
    public static void SPLInvers(float[][] matrix) {
        boolean isSquare = true;
        int newRow = matrix.length, newCol = matrix[0].length;
        float[][] matrixA = new float[newRow][newCol-1]; float[][] matrixB = new float[newRow][1];
        int row = matrixA.length, col = matrixA[0].length;

        if (row != col) {
            isSquare = false;
        }
        //Matrix Square
        if (isSquare) {
            boolean isNol = true;
            int idx = 0;

            while (isNol) {
                if (matrixB[idx][0] != 0) {
                    isNol = false;
                } else {
                    idx++;
                }
            }
            float determinan = determinanCramer.detKofaktor(matrixA);
            //B matrix nol
            if (isNol) {
                //Determinan = 0
                if (determinan == 0) {
                    System.out.println("Solusi tidak trivial, gunakan cara lain.");

                } else {
                    System.out.println("Solusinya sebagai berikut : ");
                    for (idx = 0; idx < matrixA[0].length; idx++) {
                        int n = idx + 1;
                        System.out.format("X%i = 0 %n", n);
                    }
                }
            //B bukan matrix nol
            } else {
                //Determinan = 0
                if (determinan == 0) {
                    System.out.println("Solusi tidak tunggal unik, gunakan cara lain.");

                } else {
                    int rowHasil = matrixA[0].length, colHasil = matrixB.length, idxRow, idxCol, idxPlus;
                    float[][] matrixHasil = new float[rowHasil - 1][colHasil - 1];

                    for (idxRow = 0; idxRow < rowHasil; idxRow++) {
                        int idxTemp = 0;
                        for (idxCol = 0; idxCol < colHasil; idxCol++) {
                            int temp = 0, idxTempPlus = idxRow;
                            for (idxPlus = 0; idxPlus < matrixA[0].length; idxPlus++) {
                                temp += matrixA[idxTempPlus][idxPlus]*matrixB[idxPlus][idxTemp];
                            }
                            matrixHasil[idxRow][idxCol] = temp;
                            idxTemp++;
                        }
                    }
                    System.out.println("Solusinya sebagai berikut : ");
                    for (idxRow = 0; idxRow < rowHasil; idxRow++) {
                        for (idxCol = 0; idxCol < colHasil; idxCol++) {
                            System.out.format("X%i = %.2f %n", idxRow, matrixHasil[idxRow][idxCol]);
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