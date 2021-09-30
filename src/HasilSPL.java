public class HasilSPL {
    public static double[] HasilUnikJordan(double[][] matrix) {
        int col = OperasiMatrix.getCol(matrix), row = OperasiMatrix.getRow(matrix), idxRow;
        double solusi[] = new double[col-1];

        for (idxRow = 0; idxRow < row; idxRow++) {
            solusi[idxRow] = matrix[idxRow][col-1];
        }
        return solusi;
    }

    public static double[] HasilUnikGauss(double[][] matrix) {
        int col = OperasiMatrix.getCol(matrix), row = OperasiMatrix.getRow(matrix), idxRow, idxCol, idx;

        double solusi[] = new double[col-1];
        for (idx = 0; idx < col - 1; idx++) {
            solusi[idx] = 0;
        }

        for (idxRow = row - 1; idxRow >= 0; idxRow--) {
            int idxFirstNotNol = BacaTulisMatrix.idxNot0(matrix, idxRow); 
            double temp = matrix[idxRow][col-1];
            for (idxCol = idxFirstNotNol+1; idxCol < col-1; idxCol++) {
                temp -= matrix[idxRow][idxCol];
            }
            solusi[idxRow] = temp;
        }
        return solusi;
    }

    public static String[] HasilGakUnik (double[][] matrix) {
        int col = OperasiMatrix.getCol(matrix), row = OperasiMatrix.getRow(matrix), idxRow, idxCol, idx;

  
        String solusi[] = new String[col-1];
        for (idx = 0; idx < col -1; idx++) {
            solusi[idx] = "";
        }
        char setStr = 'a';

        int firstLower = BacaTulisMatrix.idxNot0(matrix, row-1) ;
        if (firstLower != col-2) {
            for (idxCol = col-2; idxCol > firstLower; idxCol--) {
                if (matrix[row-1][idxCol] != 0) {
                    String temp = new String();
                    temp += setStr;
                    solusi[col-2] = temp;
                    setStr++;
                }
            }
        }
        for (idxRow = row - 1; idxRow >= 0; idxRow--) {
            int idxFirstNotNol = BacaTulisMatrix.idxNot0(matrix, idxRow);
            String temp = new String();
            if (matrix[idxRow][col-1] != 0) {
                temp += matrix[idxRow][col-1];
                for (idxCol = col-2; idxCol > idxFirstNotNol; idxCol--) {
                    if (matrix[idxRow][idxCol] != 0) {
                        if (matrix[idxRow][idxCol] > 0) {
                            temp += " - ";
                        } else {
                            temp += " + ";
                        }
                        temp += Math.abs(matrix[idxRow][idxCol]);
                        if (solusi[idxCol] != "") {
                            temp += "(" + solusi[idxCol] + ")";
                        }
                    }
                }
                solusi[idxFirstNotNol] = temp;
            } else {
                if (matrix[idxRow][col-2] != 0) {
                    temp += matrix[idxRow][col-2];
                    if (solusi[col-2] != "") {
                        temp += "(" + solusi[col-2] + ")";
                    } 
                }
                for (idxCol = col-3; idxCol > idxFirstNotNol; idxCol--) {
                    if (matrix[idxRow][idxCol] != 0) {
                        if (matrix[idxRow][idxCol] > 0) {
                            temp += " - ";
                        } else {
                            temp += " + ";
                        }
                        temp += Math.abs(matrix[idxRow][idxCol]);
                        if (solusi[idxCol] != "") {
                            temp += "(" + solusi[idxCol] + ")";
                        }
                    }
                solusi[idxFirstNotNol] = temp;
                }
            }
        }
        for (idx = 0; idx < col-2; idx++) {
            if (solusi[idx] == "") {
                String temp = new String();
                temp += setStr;
                solusi[idx] = temp;
                setStr++;
            }
        }
        return solusi;
    }

    public static double[] HasilCramer(double[][] matrixA, double[][] matrixB, double determinan) {
        int rowA = OperasiMatrix.getRow(matrixA) ,colA = OperasiMatrix.getCol(matrixA), idxCol;
        double[] solusi = new double[colA];
        double[][] temp = new double[rowA][colA];        

        for (idxCol = 0; idxCol < colA; idxCol++) {
            temp = BacaTulisMatrix.copy(matrixA);
            OperasiMatrix.changeCol(temp, matrixB, idxCol);
            double detTemp = determinanCramer.detKofaktor(temp);
            solusi[idxCol] = detTemp/determinan;
        }
        return solusi;
    }

    public static double[] HasilInvers(double[][] matrixA, double[][] matrixB, double determinan) {
        int rowA = OperasiMatrix.getRow(matrixA), colB = OperasiMatrix.getCol(matrixB);

        double[] solusi = new double[rowA];
        double[][] matrixInversA = InversPakeAdjoin.InversAdjoin(matrixA, determinan);
        solusi = OperasiMatrix.mutiplyMatrix(matrixInversA, matrixB, rowA, colB);
        return solusi;
    }

}
