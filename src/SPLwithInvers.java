public class SPLwithInvers {
    public static void SPLInvers(double[][] matrix) {
        int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix)-1;

        double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);

        int rowA = OperasiMatrix.getRow(matrixA), colA = OperasiMatrix.getCol(matrixA);
        int rowB = OperasiMatrix.getRow(matrixB);
        

        if (OperasiMatrix.isSquare(matrixA) && colA == rowB) {
            boolean isNol = OperasiMatrix.isMatrixBNol(matrixB);
            double determinan = determinanCramer.detKofaktor(matrixA);
            //B matrix nol & determinan = 0
            if (isNol && determinan == 0) {
                System.out.println("Solusi tidak trivial, gunakan cara lain.");
            //B bukan matrix nol & determinan = 0
            } else if (!isNol && determinan == 0) {
                System.out.println("Solusi tidak tunggal unik, gunakan cara lain.");
            } else if (!isNol && determinan != 0) {
                double[] HasilInvers = HasilSPL.HasilInvers(matrixA, matrixB, determinan);
                int idxRow;
  
                System.out.println("Solusinya sebagai berikut : ");
                for (idxRow = 0; idxRow < rowA; idxRow++) {
                    System.out.format("X%o = %.2f", (idxRow + 1), HasilInvers[idxRow]);
                    System.out.println();
                }
            }
        //bukan matrix square tidak bisa invers
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}


