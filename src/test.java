import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        double[][] matrix;
        bacaMat.setMat(10,11);
        matrix = bacaMat.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        matrix = Gauss.jordan(matrix);
        BacaTulisMatrix.tulis(matrix);
/*
        int newRow = matrix.length, newCol = matrix[0].length - 1;    
        float[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        float[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);
        float[][] temp = BacaTulisMatrix.copy(matrixA);
        
        SPLwithKofaktor.changeCol(temp, matrixB, 2);
        BacaTulisMatrix.tulis(temp);
        temp = BacaTulisMatrix.copy(matrixA);
        SPLwithKofaktor.changeCol(temp, matrixB, 1);
        BacaTulisMatrix.tulis(temp);
        
        SPLwithCramer.SPLCramer(matrix);
        */

        /*
        matrix = Gauss.jordan(matrix);
        BacaTulisMatrix.tulis(matrix);
        */
        /*

        float[] a = new float[10];
        a[0] = 6.567f;
        a[1] = 7f;
        a[2] = 7.258f;
        a[3] = 7.451f;
        a[4] = 7.548f;
        a[5] = 7.839f;
        a[6] = 8.161f;
        a[7] = 8.484f;
        a[8] = 8.709f;
        a[9] = 9f;
        for(int i=0;i<a.length;i++){
            for(int j=1;j<11;j++){
                float out = BacaInterpolasi.pow(a[i], j);
                System.out.printf("%f\n",out);
            }
            System.out.println();
        }
        */
        /*
        float[][] matrix;
        matrix = BacaInterpolasi.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        matrix = BacaInterpolasi.convertInterpol(matrix);
        SPLwithInvers.SPLInvers(matrix);*/
        /*
        int n;
        n = sc.nextInt();
        float[][] matrix;
        matrix = BacaRegresi.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        float[][] mHasil = BacaRegresi.convertKali(matrix);
        BacaTulisMatrix.tulis(mHasil);
        */
    }
}
