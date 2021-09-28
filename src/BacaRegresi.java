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
            if(op == 1){
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
            }else if(op == 2){
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
}
