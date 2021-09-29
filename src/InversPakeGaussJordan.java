public class InversPakeGaussJordan {
    public static float[][] InversGaussJordan(float[][] matrix) {
        int i,j;
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
        copyM = Gauss.jordan(copyM);
        
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix.length;j++){
                matrix[i][j] = copyM[i][j+4];
            }
        }
        return matrix;
    }
}
