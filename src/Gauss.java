public class Gauss {

    public static double[][] sortRowMatrix (double[][] matrix, int row){
        int idxRow;
        boolean sorted = false;
        double[][] copyMatrix = BacaTulisMatrix.copy(matrix);
        while(!sorted){
            sorted = true;
            for (idxRow = row; idxRow < matrix.length - 1; idxRow++) {
                int idxNotNolSeb = BacaTulisMatrix.idxNot0(matrix, idxRow);
                int idxNotNolSes = BacaTulisMatrix.idxNot0(matrix, idxRow+1);
                if (idxNotNolSeb > idxNotNolSes) {
                    matrix = BacaTulisMatrix.swapRow(copyMatrix, idxRow);
                    sorted = false;
                }
            }
        }
            
        return matrix;
    }

    public static double[][] gauss(double[][] matrix){
        double[][] copyM = new double[matrix.length][matrix[0].length];
        copyM = BacaTulisMatrix.copy(matrix);
        int i,j,k,m,n,o;
        double tag;
        boolean lock;

        for(j=0;j<matrix.length;j++){
            copyM = sortRowMatrix(copyM, j); //Mengesort idx bukan nol pertama terurut membesar
            k = BacaTulisMatrix.idxNot0(copyM, j);
            if(k<matrix[0].length){
                for(m=k;m<matrix.length;m++){
                    tag = copyM[m][k];              //Pembagi untuk setiap baris
                    for(n=k;n<copyM[0].length;n++){     
                        if(tag!=0){                 //Mencegah pembagian dengan angka 0
                            copyM[m][n] = copyM[m][n]/tag;  //Pembagian agar angka paling kiri bernilai 1
                        } 
                    }
                }

                for(i=k;i<matrix.length-1;i++){
                    lock = false;
                    for(o=k;o<copyM[0].length;o++){
                        if(copyM[i+1][k] != 0 && o==k){
                            lock = true;               //Istri minta gembok
                        }
                        if (lock){
                            copyM[i+1][o] = copyM[i+1][o] - copyM[k][o];  //Pengurangan dengan baris paling atas yang bernilai 1
                        }
                    }
                }
            }

            
        }
        return copyM;
    } 
    public static double[][] jordan(double[][] matrix){
        double[][] copyM = Gauss.gauss(matrix);
        int i,j,k,o;
        double tag;
        //PENERAPAN METODE GAUSS-JORDAN
        k=matrix[0].length-1;
        for(j=matrix[0].length-1;j>0;j--){
            for(i=k;i>0;i--){
                tag = copyM[i-1][k];            //Pengali untuk setiap baris
                for(o=k;o<copyM[0].length;o++){
                    
                    if(copyM[k][k] != 0){       //Mencegah pengurangan baris yang depannya sudah 0
                        copyM[i-1][o] = copyM[i-1][o] - (copyM[k][o]*tag);      //Pengurangan dengan baris paling bawah yang bernilai 1
                    //System.out.printf("(%d,%d,%d)\n",i,o,k);
                    }
                    
                }
            }
            k--;

        }
        return copyM;
    }
}


