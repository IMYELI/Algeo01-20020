public class InverswithGaussJordan() {
    public static float[][] InversGaussJordan(float[][] matrix) {
        int pilMenu,i,j,k,m,n,o;
        float tag;

        float[][] id = new float[matrix.length][matrix.length];
        id = IdentitasGenerator.generate(matrix.length);
        float[][] copyM = new float[matrix.length][matrix.length*2];
        float determinan = determinanCramer.detKofaktor(matrix);
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
        return matrix;
    }
}