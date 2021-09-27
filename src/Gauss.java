public class Gauss {
    public static float[][] gauss(float[][] matrix){
        float[][] copyM = new float[matrix.length][matrix[0].length];
        copyM = BacaTulisMatrix.copy(matrix);
        int i,j,k,m,n,o;
        float tag;
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
        return copyM;
    } 
    public static float[][] jordan(float[][] matrix){
        float[][] copyM = Gauss.gauss(matrix);
        BacaTulisMatrix.tulis(copyM);
        int i,j,k,o;
        float tag;
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
        return copyM;
    }
}