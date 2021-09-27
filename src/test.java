import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        float[][] matrix;
        bacaMat.setMat(3,4);
        matrix = bacaMat.baca(sc);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        matrix = Gauss.jordan(matrix);
        BacaTulisMatrix.tulis(matrix);
    }
}
