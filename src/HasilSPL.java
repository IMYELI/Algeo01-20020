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
        for (idx = 0; idx < col; idx++) {
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
        int col = OperasiMatrix.getCol(matrix), row = OperasiMatrix.getRow(matrix), idxRow, idxCol, idxCek, idx;

        String solusi[] = new String[col-1];
        for (idx = 0; idx < col; idx++) {
            solusi[idx] = "";
        }
        char setStr = 'a';

        for (idxRow = row - 1; idxRow >= 0; idxRow--) {
            int idxFirstNotNol = BacaTulisMatrix.idxNot0(matrix, idxRow); 
            for (idxCol = idxFirstNotNol; idxCol < col; idxCol++) {
                String temp = new String();
                if (idxRow == row - 1 && OperasiMatrix.isAllNol(matrix)) {
                    temp += setStr;
                    solusi[idxFirstNotNol] = temp;
                    setStr++;
                } else {
                    if (OperasiMatrix.isSingleVar(matrix, idxRow, idxFirstNotNol)) {
                        if (matrix[idxRow][col-1] != 0) {
                            temp += matrix[idxRow][col-1];
                            solusi[idxFirstNotNol] = temp;
                        } else {
                            temp += setStr;
                            solusi[idxFirstNotNol] = temp;
                            setStr++;
                        }
                    } else {
                        for (idxCek = idxFirstNotNol + 1; idxCek < col; idxCek++) {
                            if (idxCek == col-1) {
                                if (OperasiMatrix.syarat(matrix, solusi, idxRow, idxCek)) {
                                        temp += " + " + matrix[idxRow][idxCek] + "(" + solusi[idxCek] + ")";
                                        solusi[idxFirstNotNol] = temp;
                                }
                            } else if (idxCek == idxFirstNotNol+1) {
                                if (OperasiMatrix.syarat(matrix, solusi, idxRow, idxCek)) {
                                        temp += matrix[idxRow][idxCek] + "(" + solusi[idxCek] + ")";
                                        solusi[idxFirstNotNol] = temp;
                                }
                            } else {
                                if (OperasiMatrix.syarat(matrix, solusi, idxRow, idxCek)) {
                                        temp += " + -" + matrix[idxRow][idxCek] + "(" + solusi[idxCek] + ")";
                                        solusi[idxFirstNotNol] = temp;
                                    }
                            }
                        }

                    }
                }
            }
        }
        for (idx = 0; idx < col; idx++) {
            String temp = new String();
            if (solusi[idx] == "") {
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
