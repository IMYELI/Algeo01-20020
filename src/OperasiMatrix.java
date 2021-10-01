

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
    public static double[] mutiplyMatrix (double[][] matrixA, double[][] matrixB, int row, int col) {
        int rowHasil = row, idxRow, idxPlus;
        double[] matrixHasil = new double[rowHasil];


        for (idxRow = 0; idxRow < rowHasil; idxRow++) {
                double temp = 0;
                int idxTempPlus = idxRow;
                for (idxPlus = 0; idxPlus < rowHasil; idxPlus++) {
                    temp += matrixA[idxTempPlus][idxPlus]*matrixB[idxPlus][0];
                }
                matrixHasil[idxRow] = temp;
            }
        return matrixHasil;
    }
    public static void changeCol(double[][] matrixA, double[][] matrixB, int col) {
        int row = matrixA.length, idxRow;

        for (idxRow = 0; idxRow < row; idxRow++) {
            matrixA[idxRow][col] = matrixB[idxRow][0];
        }
    }
    public static boolean isNotSolution(double[][] matrix) {
        boolean isNot = true;
        int idx, col = getCol(matrix), firstNotNolRow = idxRowNotNol(matrix);

        for (idx = 0; idx < col-1; idx++) {
            if (matrix[firstNotNolRow][idx] != 0) {
                isNot = false;
            }
        }
        if (matrix[firstNotNolRow][col-1] == 0) {
            isNot = false;
        }
        return isNot;
    }
    public static boolean isAllNol(double[][] matrix, int row) {
        boolean isAll = true;
        int idx, col = getCol(matrix);

        for (idx = 0; idx < col; idx++) {
            if (matrix[row][idx] != 0) {
                isAll = false;
            }
        }
        return isAll;
    }

    public static int idxRowNotNol (double[][] matrix) {
    int idxRow = getRow(matrix) - 1;

    while (isAllNol(matrix, idxRow) && idxRow > 0) {
        idxRow--;
    } 
    return idxRow;
    }

    public static boolean solusiUnik (double[][] matrix, int lowerRow) {
        int col = getCol(matrix);
        boolean solusi = true;

        if ((BacaTulisMatrix.idxNot0(matrix, lowerRow) != col - 2 && matrix[lowerRow][col-1] == 0) || col-1 != lowerRow+1) {
            solusi = false;
        }
        return solusi;
    }
}


