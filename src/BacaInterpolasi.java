import java.util.Scanner;
import java.io.FileNotFoundException;  
import java.io.File;
public class BacaInterpolasi {
    public static float[][] baca(Scanner sc){
        System.out.print("Masukan banyak titik: ");
        int n = sc.nextInt();
        System.out.println("Pilihan input: ");
        System.out.println("1. Keyboard");
        System.out.println("2. file");
        System.out.print("Pilihan: ");
        int op = sc.nextInt();
        sc.nextLine();
        float[][] mHasil = new float[n][2];
        int i;
        try{
            if(op == 1){
                for(i=0;i<n;i++){
                    String titik = sc.nextLine();
                    titik = titik.substring(1,titik.length()-1);
                    String[] rowTitik = titik.split(",");
                    mHasil[i][0] = Float.parseFloat(rowTitik[0]);
                    mHasil[i][1] = Float.parseFloat(rowTitik[1]);
                }

            }else if(op == 2){
                System.out.print("Masukkan path lengkap file: ");
                String pathFile = sc.next();
                File file = new File(pathFile);    
                Scanner dataReader = new Scanner(file);  
                i = 0;
                while (dataReader.hasNextLine()) {  
                    String lineData = dataReader.nextLine(); //Mengambil tiap line dalam 
                    String[] rowMatrix = lineData.split(" ");
                    mHasil[i][0] = Float.parseFloat(rowMatrix[0]);
                    mHasil[i][1] = Float.parseFloat(rowMatrix[1]);
                    i++;           
                }
                dataReader.close(); 
            }else{
                System.out.println("Opsi tidak ada.");
            }

        }catch (FileNotFoundException exception) {  
            System.out.println("File tidak ditemukan");  
        } 

        return mHasil;
    }

    public static float[][] convertInterpol(float[][] matrix){
        float[][] mHasil = new float[matrix.length][matrix.length+1];
        int i,j;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix.length +1;j++){
                if(j == 0){
                    mHasil[i][j] = 1;
                }else if(j!=matrix.length){    
                    mHasil[i][j] = pow(matrix[i][0],j);
                }else{
                    mHasil[i][j] = matrix[i][1];
                }
                
            }
        }
        return mHasil;
    }

    public static float pow(float m,int n){
        int i;
        float k;
        k = m;
        for(i=1;i<n;i++){
            k = k*m;
        }
        return k;
    }

    public static void tulis(float[] mVar){
        int i;
        boolean negatif;
        for(i=0;i<mVar.length;i++){
            negatif = false;
            if(i == 0){
                System.out.print("Y = ");
            }
            if(i<mVar.length-2){
                if(mVar[i+1]<0){
                    negatif = true;
                }
            }
            if(i!=0){
                System.out.printf(" %.3fX^%d ",mVar[i],i+1);
            }else{
                System.out.printf(" %.3fX ",mVar[i]);
            }
            
            if(i!=mVar.length-1&&!negatif){
                System.out.print("+");
            }
        }
    }
    
}
