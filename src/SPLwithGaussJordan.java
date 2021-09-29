public class SPLwithGaussJordan {
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

    public void SPLGaussJordan(double[][] matrix) {
        double[][] matrixHasil;
        int solusi = 1, idx, row, col;
        boolean isAllNol = true, isSquare = true;

        matrixHasil = Gauss.jordan(matrix);
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
            double solusiX[] = new double[col-1];

            for (idx = row - 1; idx >= 0; idx--) {
                solusiX[idx] = matrixHasil[idx][col-1];
            }
            int idxSol;
            int colSol = solusiX.length;
            for (idxSol = colSol - 1; idx >= 0; idxSol++) {
                int n = colSol - idx + 1;
                System.out.format("X%i = %.2f %n", n, solusiX[idxSol]);
            }
        } else if (solusi == 2) {
            System.out.println("Tidak ada Solusi");
        } else if (solusi == 3) {
            double[] solusiX = new double[col];
            int idxRow, idxCol, idxSol = 0;

            for (idxRow = 0; idxRow < row; idxRow++) {
                int notNol = 0;
                for (idxCol = 0; idxCol < idxCol; idxCol++) {
                    if (matrixHasil[idxRow][idxCol] != 0) {
                        notNol++;
                    }
                }
                if (notNol == 1) {
                    int firstNol = BacaTulisMatrix.idxNot0(matrixHasil, idxRow);
                    solusiX[idxSol] = matrixHasil[idxRow][firstNol];
                    idxSol++;
                }
            }

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

