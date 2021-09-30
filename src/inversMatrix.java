import java.util.Scanner; 
import java.io.FileWriter;
import java.io.IOException;
public class inversMatrix{
    public static double[][] invers(double[][] matrix, Scanner read, FileWriter rekam){
        int pilMenu;
        boolean kembali = false;
        double determinan = determinanCramer.detKofaktor(matrix);
        double[][] hasilinversMatrix = BacaTulisMatrix.copy(matrix);

        while(!kembali){
            System.out.println("Pilihan menu invers: ");
            System.out.println("1. Metode eliminasi Gauss-Jordan");
            System.out.println("2. Metode adjoin");
            System.out.println("3. Kembali ke menu utama");
            System.out.print("Pilihan menu: ");
            pilMenu = read.nextInt();
            if(determinan == 0){
                System.out.println("Tidak mempunyai matrix balikan");
                return matrix;
            }
            if(pilMenu == 1){
                hasilinversMatrix = InversPakeGaussJordan.InversGaussJordan(matrix);
                System.out.println("\nMatrix setelah di inverse: ");
                BacaTulisMatrix.tulis(hasilinversMatrix);
                try{
                    rekam.write("\n\nMatrix setelah diinverse:\n");
                BacaTulisMatrix.rekamMatrixToString(hasilinversMatrix, rekam);
                }catch(IOException e){

                }
                
            }else if(pilMenu == 2){
                hasilinversMatrix = InversPakeAdjoin.InversAdjoin(matrix, determinan);
                System.out.println("\nMatrix setelah di inverse: ");
                BacaTulisMatrix.tulis(hasilinversMatrix);
                try{
                    rekam.write("\n\nMatrix setelah diinverse:\n");
                BacaTulisMatrix.rekamMatrixToString(hasilinversMatrix, rekam);
                }catch(IOException e){
                    
                }
            }else if(pilMenu == 3){
                kembali = true;
                return hasilinversMatrix;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }
        }
        return matrix;
    }
}

