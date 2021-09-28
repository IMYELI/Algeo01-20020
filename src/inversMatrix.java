import java.util.Scanner; 
public class inversMatrix{
    public static float[][] invers(float[][] matrix, Scanner read){
        int pilMenu;
        boolean kembali = false;
        float determinan = determinanCramer.detKofaktor(matrix);
        float[][] hasilinversMatrix;

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
                hasilinversMatrix = InverswithGaussJordan.InversGaussJordan(matrix);
                System.out.println("\nMatrix setelah di inverse: ");
                BacaTulisMatrix.tulis(hasilinversMatrix);
            }else if(pilMenu == 2){
                /*
                hasilinversMatrix = InverswithAdjoin.InversAdjoin(matrix);
                System.out.println("\nMatrix setelah di inverse: ");
                BacaTulisMatrix.tulis(hasilinversMatrix);*/
            }else if(pilMenu == 3){
                kembali = true;
                return matrix;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }
        }
        return matrix;
    }
}