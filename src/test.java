import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        /*
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        float[][] matrix;
        bacaMat.setMat(3,3);
        matrix = bacaMat.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        matrix = InverswithAdjoin.InversAdjoin(matrix, determinanCramer.detKofaktor(matrix));
        BacaTulisMatrix.tulis(matrix);
        */
        float[][] matrix;
        matrix = BacaInterpolasi.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        matrix = BacaInterpolasi.convertInterpol(matrix);
        SPLwithInvers.SPLInvers(matrix);
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
