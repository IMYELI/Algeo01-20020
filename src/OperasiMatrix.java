public class OperasiMatrix {
    // Membuat matrix A
    public static double[][] makeMatrixA(double[][] matrix, int row, int col) {
        double[][] MatrikA = new double[row][col];
        int idxRowNew, idxColNew;
    
        for (idxRowNew = 0; idxRowNew < row; idxRowNew++) {
            for (idxColNew = 0; idxColNew < col; idxColNew++) {
                MatrikA[idxRowNew][idxColNew] = matrix[idxRowNew][idxColNew];
            }
        }
        return MatrikA;
    }
    // Membuat matrix B
    public static double[][] makeMatrixB(double[][] matrix, int row, int col) {
        double[][] MatrikB = new double[row][1];
        int idxRowNew, idxColNew;
    
        for (idxRowNew = 0; idxRowNew < row; idxRowNew++) {
            for (idxColNew = 0; idxColNew < 1; idxColNew++) {
                MatrikB[idxRowNew][idxColNew] = matrix[idxRowNew][col];
            }
        }
        return MatrikB;
    }
    // Mendapat baris matrix
    public static int getRow(double[][] matrix) {
            
        return matrix.length;
    }
    // Mendapatkan kolom matrix
    public static int getCol(double[][] matrix) {
            
        return matrix[0].length;
    }
    //Mengecek persegi atau Tidak
    public static boolean isSquare(double[][] matrix) {

        return (getRow(matrix) == getCol(matrix));
    }
    //Mengeck matrixB nol semua atau tidak
    public static boolean isMatrixBNol(double[][] matrix) {
        boolean isNol = true;
        int idx = 0;

        while (isNol && idx < getRow(matrix)) {
            if (matrix[idx][0] != 0) {
                isNol = false;
            } else {
                idx++;
            }
        }
        return isNol;
    }
    // Mengkalikan matirx
    public static double[][] mutiplyMatrix (double[][] matrixA, double[][] matrixB, int row, int col) {
        int rowHasil = row, colHasil = col, idxRow, idxCol, idxPlus;
        double[][] matrixHasil = new double[rowHasil][colHasil];

        for (idxRow = 0; idxRow < rowHasil; idxRow++) {
            int idxTemp = 0;
            for (idxCol = 0; idxCol < colHasil; idxCol++) {
                double temp = 0;
                int idxTempPlus = idxRow;
                for (idxPlus = 0; idxPlus < matrixA[0].length; idxPlus++) {
                    temp += matrixA[idxTempPlus][idxPlus]*matrixB[idxPlus][idxTemp];
                }
                matrixHasil[idxRow][idxCol] = temp;
                idxTemp++;
            }
        }
        return matrixHasil;
    }
    public static void changeCol(double[][] matrixA, double[][] matrixB, int col) {
        int row = matrixA.length, idxRow;

        for (idxRow = 0; idxRow < row; idxRow++) {
            matrixA[idxRow][col] = matrixB[idxRow][0];
        }
    }
}


