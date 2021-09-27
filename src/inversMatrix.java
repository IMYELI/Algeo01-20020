import java.util.Scanner; 
public class inversMatrix{
    public static float[][] invers(float[][] matrix, Scanner read){
        int pilMenu,i,j,k,m,n,o,row,col,rowIn,colIn;
        float tag;
        boolean kembali = false;
        float determinan = DeterminanCramer.det(matrix);
        float[][] tmp2 = BacaTulisMatrix.copy(matrix);
        float[][] tmp = new float[matrix.length-1][matrix[0].length-1];
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
                float[][] id = new float[matrix.length][matrix.length];
                id = IdentitasGenerator.generate(matrix.length);
                float[][] copyM = new float[matrix.length][matrix.length*2];
                //Menambahkan matriks identitas di kanan matriks yang akan dicari inversnya
                for(i=0;i<matrix.length;i++){
                    for(j=0;j<matrix.length*2;j++){
                        if(j<matrix.length){
                            copyM[i][j] = matrix[i][j];
                        }else{
                            copyM[i][j] = id[i][j%matrix.length];
                        }
                    }
                }

                //PENERAPAN METODE GAUSS
                k = 0;
                for(j=0;j<matrix.length;j++){
                    for(m=k;m<matrix.length;m++){
                        tag = copyM[m][k];              //Pembagi untuk setiap baris
                        for(n=k;n<copyM[0].length;n++){      
                            copyM[m][n] = copyM[m][n]/tag;  //Pembagian agar angka paling kiri bernilai 1
                        }
                    }
                    for(i=k;i<matrix.length-1;i++){
                        for(o=k;o<copyM[0].length;o++){
                            copyM[i+1][o] = copyM[i+1][o] - copyM[k][o];    //Pengurangan dengan baris paling atas yang bernilai 1
                        }
                    }
                    k++;
                }

                //PENERAPAN METODE GAUSS-JORDAN
                k=matrix.length-1;
                for(j=matrix[0].length-1;j>0;j--){
                    for(i=k;i>0;i--){
                        tag = copyM[i-1][k];            //Pengali untuk setiap baris
                        for(o=k;o<copyM[0].length;o++){
                            copyM[i-1][o] = copyM[i-1][o] - (copyM[k][o]*tag);      //Pengurangan dengan baris paling bawah yang bernilai 1
                            //System.out.printf("(%d,%d,%d)\n",i,o,k);
                        }
                    }
                    k--;
                }
                for(i=0;i<matrix.length;i++){
                    for(j=0;j<matrix.length;j++){
                        matrix[i][j] = copyM[i][j+3];
                    }
                }
                System.out.println("\nMatrix setelah di inverse: ");
                BacaTulisMatrix.tulis(matrix);   
            }else if(pilMenu == 2){
                //MEMBUAT ADJOIN
                for(row=0;row<matrix.length;row++){
                    for(col=0;col<matrix[0].length;col++){
                        rowIn = 0;
                        for(i=0;i<matrix.length;i++){
                            colIn = 0;
                            for(j=0;j<matrix[0].length;j++){
                                if(i != row && j != col){
                                    tmp[rowIn][colIn] = matrix[i][j];
                                    colIn++;
                                    if(colIn == tmp.length){
                                        rowIn++;
                                    }
                                }
                                

                            }
                            

                        }
                        System.out.println();
                        if((row+col)%2 == 0){
                            tmp2[row][col] = DeterminanCramer.det(tmp);
                        }else{
                            tmp2[row][col] = DeterminanCramer.det(tmp)*(-1);
                        }

                    }
                        
                }
                matrix = BacaTulisMatrix.transpose(tmp2);
                for(i=0;i<matrix.length;i++){
                    for(j=0;j<matrix[0].length;j++){
                        matrix[i][j] /= determinan;
                    }
                }
                System.out.println("\nMatrix setelah di inverse: ");
                BacaTulisMatrix.tulis(matrix);
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