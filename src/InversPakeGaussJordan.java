public class InversPakeGaussJordan {
    public static double[][] InversGaussJordan(double[][] matrix) {
        int i,j;
        double[][] id = new double[matrix.length][matrix.length];
        id = IdentitasGenerator.generate(matrix.length);
        
        double[][] copyM = new double[matrix.length][matrix.length*2];
        
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
        BacaTulisMatrix.tulis(copyM);
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


