import java.util.Scanner;
import java.io.FileNotFoundException; 
import java.io.File;
public class BacaRegresi {
    public static float[][] baca(Scanner sc){
        int n,jumlah,op;
        int i,j,k,l;
        System.out.print("Masukan jumlah peubah x yang diinginkan: ");
        n = sc.nextInt();
        System.out.println();
        System.out.print("Masukan jumlah data yang ingin dimasukan: ");
        jumlah = sc.nextInt();
        System.out.println();
        System.out.println("Pilihan input: ");
        System.out.println("1. Keyboard");
        System.out.println("2. File");
        System.out.print("Pilihan: ");
        op = sc.nextInt();
        float[][] matrix = new float[n+1][jumlah];

        try{
            if(op == 1){                    //INPUT MANUAL
                for(k=0;k<n+1;k++){
                    if(k != matrix.length-1){
                        System.out.printf("Masukan nilai X%d:\n",k);
                    }else{
                        System.out.println("Masukan nilai Y:");
                    }
                    for(l=0;l<jumlah;l++){
                        matrix[k][l] = sc.nextFloat();
                    }
                }
            }else if(op == 2){          //INPUT FILE
                System.out.print("Masukkan path lengkap file: ");
                String pathFile = sc.next();
                File file = new File(pathFile);    
                Scanner dataReader = new Scanner(file); 
                i = 0;
                while (dataReader.hasNextLine()) {
                    String lineData = dataReader.nextLine(); //Mengambil tiap line dalam 
                    String[] rowMatrix = lineData.split(" ");
                    for(j=0;j<matrix.length;j++){
                        matrix[(j+n)%(n+1)][i] = Float.parseFloat(rowMatrix[j]);
                    }
                    i++;
                }

                dataReader.close();
            }else{
                System.out.println("Opsi tidak ada.");
            }
        }catch (FileNotFoundException exception){
            System.out.println("File tidak ditemukan");  
        }
        return matrix;
    }

    public static float[][] convertKali(float[][] matrix){      //Membuat menjadi bentuk utama matrix
        float[][] mHasil = new float[matrix.length+1][matrix.length];
        int i,j,k;
        for(i=0;i<matrix.length+1;i++){
            for(j=0;j<matrix.length;j++){
                if(i==0 && j==0){         //untuk n
                    mHasil[i][j] = matrix[0].length;
                }else if(i == 0){       //Untuk sigma X1 hingga Xi
                    mHasil[i][j] = 0;
                    for(k=0;k<matrix[0].length;k++){
                        mHasil[i][j] += matrix[j-1][k];
                    }
                    
                }else if(j==0){         //Untuk Sigma X1 hingga Xi
                    mHasil[i][j] = 0;
                    for(k=0;k<matrix[0].length;k++){
                        mHasil[i][j] += matrix[i-1][k];
                    }
                }else {                 //Untuk sigma perkalian sisanya
                    mHasil[i][j] = 0;
                    for(k=0;k<matrix[0].length;k++){
                        mHasil[i][j] += (matrix[i-1][k]*matrix[j-1][k]);
                    }
                }
            }
        }
        float[][] mPalingHasil = new float[matrix.length][matrix.length+1];
        for(i=0;i<mPalingHasil.length;i++){
            for(j=0;j<mPalingHasil[0].length;j++){
                if(j == mPalingHasil[0].length-1){
                    mPalingHasil[i][j] = mHasil[j][i];
                }else{
                    mPalingHasil[i][j] = mHasil[i][j];
                }
            }
        }
        return mPalingHasil;
    }

    public static void tulis(float[][] matrix){
        int i,j;
        boolean negatif;
        for(i=0;i<matrix.length;i++){
            negatif = false;
            if(i==matrix.length-1){
                System.out.print(" = ");
            }
            if(i==0){
                System.out.printf("%f",matrix[i][matrix[0].length-1]);
            }else{
                System.out.printf("%fX%d",matrix[i][matrix[0].length-1],i);
            }
            if(matrix[i][matrix[0].length-1]<0){
                negatif = true;
            }
            if (i!= matrix.length-1 && !negatif){
                System.out.print("+");
            }
        }
    }
}
