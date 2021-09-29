import java.io.File;   
import java.io.FileNotFoundException;    
import java.util.Scanner; 
   
public class BacaTulisMatrix {  
    private int m;
    private int n;

    public void setMatSquare(int m){
        this.m = m;
        this.n = m;
    }
    public void setMat(int m,int n){
        this.m = m;
        this.n = n;
    }
    public double[][] baca(Scanner readOp) {  
        System.out.println("Pilihan input: ");
        System.out.println("1. Keyboard");
        System.out.println("2. file");
        System.out.print("Pilihan: ");
        int op = readOp.nextInt();
        double[][] matrix = new double[this.m][this.n];
        int i = 0;
        int j;
        try { 
            if(op == 1){
                for(i=0;i<this.m;i++){
                    for(j=0;j<this.n;j++){
                            matrix[i][j] = readOp.nextDouble();              
                        }
                    }

            }else if(op == 2){
                System.out.print("Masukkan path lengkap file: ");
                String pathFile = readOp.next();
                File file = new File(pathFile);    
                Scanner dataReader = new Scanner(file);  
                while (dataReader.hasNextLine()) {  
                    String lineData = dataReader.nextLine(); //Mengambil tiap line dalam file
                    String[] rowMatrix = lineData.split(" ",0);
                    for(j = 0;j<rowMatrix.length;j++){
                        matrix[i][j] = Double.parseDouble(rowMatrix[j]);
                    }
                    i++;                  
                }
                dataReader.close(); 
            }else{
                System.out.println("Opsi tidak ada.");
            }
            
        } catch (FileNotFoundException exception) {  
            System.out.println("File tidak ditemukan");  
        }  
        return matrix; 
    }  

    public static void tulis(double[][] matrix){
        int i,j;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
                if(j==matrix[0].length-1){
                    System.out.println();
                }
            }
            
        }
    }

    public static double[][] copy(double[][] matrix){
        double[][] matrix2 = new double[matrix.length][matrix[0].length];
        int i,j;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                matrix2[i][j] = matrix[i][j];
            }
        }
        return matrix2;
    }

    public static double[][] transpose(double[][] matrix){
        double[][] matrix2 = new double[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        while(i<matrix.length){
            j = 0;
            while(j<matrix[0].length){
                matrix2[i][j] = matrix[j][i];
                j++;
            }
            i++;
        }
        return matrix2;
    }

    public static int idxNot0(double[][] matrix,int i){
        int j;
        int idx = 0;
        for(j=0;j<matrix[0].length;j++){
            if(matrix[i][j] != 0){
                return idx;
            }
            idx++;
        }
        return idx;
    }

    public static double[][] swapRow(double[][] matrix, int i){
        double[][] copyM = BacaTulisMatrix.copy(matrix);
        int j;
        for(j=0;j<matrix[0].length;j++){
            matrix[i][j] = copyM[i+1][j];
            matrix[i+1][j] = copyM[i][j];
        }
        return matrix;
    }
    public static void tulis1D(double[] matrix){
        int i;
        for(i=0;i<matrix.length;i++){
            System.out.printf("%f ",matrix[i]);
        }
    }
}  


