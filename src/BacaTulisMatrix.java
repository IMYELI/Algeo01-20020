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
    public float[][] baca(Scanner readOp) {  
        System.out.println("Pilihan input: ");
        System.out.println("1. Keyboard");
        System.out.println("2. file");
        int op = readOp.nextInt();
        float[][] matrix = new float[this.m][this.n];
        int i = 0;
        int j;
        try { 
            if(op == 1){
                for(i=0;i<this.m;i++){
                    for(j=0;j<this.n;j++){
                            matrix[i][j] = readOp.nextFloat();              
                        }
                    }

            }else if(op == 2){
                String pathFile = readOp.next();
                File file = new File(pathFile);    
                Scanner dataReader = new Scanner(file);  
                while (dataReader.hasNextLine()) {  
                    String lineData = dataReader.nextLine(); //Mengambil tiap line dalam file
                    String[] rowMatrix = lineData.split(" ",0);
                    for(j = 0;j<rowMatrix.length;j++){
                        matrix[i][j] = Float.parseFloat(rowMatrix[j]);
                    }
                    i++;                  
                }
                dataReader.close(); 
            }
            
        } catch (FileNotFoundException exception) {  
            System.out.println("File tidak ditemukan");  
        }  
        return matrix; 
    }  

    public void tulis(float[][] matrix){
        int i,j;
        for(i=0;i<this.m;i++){
            for(j=0;j<this.n;j++){
                System.out.print(matrix[i][j] + " ");
                if(j==this.n-1){
                    System.out.println();
                }
            }
            
        }
    }
}  
