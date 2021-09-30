import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        double[][] matrix;
        bacaMat.setMat(6,5);
        matrix = bacaMat.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        
        double[][] matrixHasil = Gauss.gauss(matrix);
        BacaTulisMatrix.tulis(matrixHasil);
        
        
        SPLwithGaussJordan.SPLGaussJordan(matrix);

        /*
        int newRow = matrix.length, newCol = matrix[0].length - 1;    
        double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
        double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);
        double[][] temp = BacaTulisMatrix.copy(matrixA);
        
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
        double[] a = new double[10];
        a[0] = 2;
        a[1] = 3;
        a[2] = 4;
        a[3] = 5;
        a[4] = 6;
        a[5] = 7;
        a[6] = 8;
        a[7] = 9;
        a[8] = 10;
        a[9] = 11;
        for(int i=0;i<a.length;i++){
            for(int j=1;j<11;j++){
                double out = BacaInterpolasi.pow(a[i], j);
                System.out.printf("%f\n",out);
            }
            System.out.println();
        }
        */
        /*
        double[][] matrix;
        matrix = BacaInterpolasi.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        matrix = BacaInterpolasi.convertInterpol(matrix);
        SPLwithInvers.SPLInvers(matrix);*/
        /*
        int n;
        n = sc.nextInt();
        double[][] matrix;
        matrix = BacaRegresi.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        double[][] mHasil = BacaRegresi.convertKali(matrix);
        BacaTulisMatrix.tulis(mHasil);
        */
    }
}
