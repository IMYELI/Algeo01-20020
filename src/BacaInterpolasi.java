import java.util.Scanner;
import java.io.FileNotFoundException;  
import java.io.File;
public class BacaInterpolasi {
    public static float[][] baca(Scanner sc,int n){
        System.out.println("Pilihan input: ");
        System.out.println("1. Keyboard");
        System.out.println("2. file");
        System.out.print("Pilihan: ");
        int op = sc.nextInt();
        float[][] mHasil = new float[n][2];
        int i,j;
        try{
            if(op == 1){
                for(i=0;i<n;i++){
                    String titik = sc.nextLine();
                    String[] rowTitik = titik.split("(,)");
                    mHasil[i][0] = Float.parseFloat(rowTitik[0]);
                    mHasil[i][1] = Float.parseFloat(rowTitik[1]);
                }

            }else if(op == 2){
                System.out.print("Masukkan path lengkap file: ");
                String pathFile = sc.next();
                File file = new File(pathFile);    
                Scanner dataReader = new Scanner(file);  
                while (dataReader.hasNextLine()) {  
                    String lineData = dataReader.nextLine(); //Mengambil tiap line dalam file
                    String[] rowMatrix = lineData.split(" ",0);
                    for(i = 0;i<n;i++){
                        mHasil[i][0] = Float.parseFloat(rowMatrix[0]);
                        mHasil[i][1] = Float.parseFloat(rowMatrix[1]);
                    }               
                }
                dataReader.close(); 
            }

        }catch (FileNotFoundException exception) {  
            System.out.println("File tidak ditemukan");  
        }  
        return mHasil;
    }
}
