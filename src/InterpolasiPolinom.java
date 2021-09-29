public class InterpolasiPolinom {
    public static double[] interpolasi(double[][] matrix){
        double[][] mHasil = new double[matrix.length][matrix.length+1];
        int i;
        mHasil = BacaInterpolasi.convertInterpol(matrix);
        BacaTulisMatrix.tulis(mHasil);
        mHasil = Gauss.jordan(mHasil);
        double[] mVar = new double[mHasil.length];
        BacaTulisMatrix.tulis(mHasil);
        for(i=0;i<mHasil.length;i++){
            mVar[i] = mHasil[i][mHasil[0].length-1];
        }
        
        return mVar;
    }

    public static double taksir(double[] matrix,double taksiran){
        int i;
        double hasil = matrix[0];
        for(i=1;i<matrix.length;i++){
            hasil = hasil + (matrix[i]*BacaInterpolasi.pow(taksiran,i));
        }
        return hasil;
    }

}


