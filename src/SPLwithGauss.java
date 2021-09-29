public class SPLwithGauss {
    public static boolean isRowManySolution(double[] row) {
        int col = 0;
        boolean isManySolution = true;

        while (isManySolution && col < row.length) {
            if (row[col] != 0) {
                isManySolution = false;
            } else {
                col++;
            }
        }
        return isManySolution;
    }

    public static void SPLGauss(double[][] matrix) {
        double[][] matrixHasil;
        int solusi = 1, idx, row, col;
        boolean isAllNol = true, isSquare = true;

        matrixHasil = Gauss.gauss(matrix);
        col = matrixHasil[0].length;
        row = matrix.length;

        if (row != col - 1) {
            isSquare = false;
        }

        for (idx = 0; idx < col - 1; idx++) {
            if (matrixHasil[row-1][idx] != 0) {
                isAllNol = false;
            }
        }
        if (isAllNol) {
            solusi = 2;
        } else if (isSquare) {
            solusi = 3;
        }

        if (solusi == 1) {
            double solusiX[] = new double[row-1];
            int idxUnik, idxHasilUnik;

            for (idxUnik = row - 1; idxUnik >= 0; idxUnik--) {
                solusiX[idxUnik] = matrixHasil[idxUnik][col];
                int idxSol;
                for (idxSol = idxUnik + 1; idxSol < col; idxSol++) {
                    solusiX[idxUnik] -= matrixHasil[idxUnik][idxSol] * solusiX[idxSol];
                }
            }
            int colSol = solusiX.length;
            for (idxHasilUnik = colSol - 1; idxHasilUnik >= 0; idxHasilUnik--) {
                int n = colSol - idxHasilUnik + 1;
                System.out.format("X%i = %.2f %n", n, solusiX[idxHasilUnik]);
            }

        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");
        }  else if (solusi == 3) {
            double[] solusiX = new double[col];
            int idxRow, idxCol;
            
            for (idxRow = 0; idxRow < row; idxRow++) {
                int firstNol = BacaTulisMatrix.idxNot0(matrixHasil, idxRow);
                for (idxCol = firstNol; idxCol < col; idxCol++) {
                    System.out.format("x%i =", idxCol);
                    int idxCek = 0;
                    boolean isHasValue = false;
                    while (!isHasValue) {
                        if (matrixHasil[idxRow][idxCol] == solusiX[idxCek]) {
                            isHasValue = true;
                        } else {
                            idxCek++;
                        }
                    }
                    if (matrixHasil[idxRow][idxCol] != 0 && idxCol < col - 1 && !isHasValue && idxCol != firstNol) {
                        if (matrixHasil[idxRow][idxCol] > 0) {
                            if (idxCol != firstNol+1 && idxCol != col-1) {
                                System.out.printf(" - ");
                            }
                            System.out.format(" &.2fx%i ", matrixHasil[idxRow][idxCol], idxCol);
                        } else {
                            if (idxCol != firstNol+1 && idxCol != col-1) {
                                System.out.printf(" + ");
                            }
                            System.out.format(" &.2fx%i ", matrixHasil[idxRow][idxCol], idxCol);
                        }      
                    } else if (matrixHasil[idxRow][idxCol] != 0 && idxCol == (col - 1) && !isHasValue && idxCol != firstNol) {
                        if  (matrixHasil[idxRow][idxCol] > 0) {   
                            System.out.printf(" - ");
                            System.out.format(" &.2fx%i ", matrixHasil[idxRow][idxCol], idxCol);
                            
                        } else {
                            System.out.printf(" + ");
                            System.out.format(" &.2fx%i ", matrixHasil[idxRow][idxCol], idxCol);                       
                        }
                    } else if (matrixHasil[idxRow][idxCol] != 0 && !isHasValue && idxCol != firstNol && idxRow == (row -1)) {
                        System.out.format(" x%i ", idxCol);
                    } else if (isHasValue) {
                        System.out.format(" %.2f ", matrixHasil[idxRow][idxCol]);
                    }
                    System.out.println();        
                }

            }
    
        }

    }
}    
