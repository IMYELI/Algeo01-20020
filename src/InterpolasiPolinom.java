public class InterpolasiPolinom {
    public static float[] interpolasi(float[][] matrix){
        float[][] mHasil = new float[matrix.length][matrix.length+1];
        int i;
        mHasil = BacaInterpolasi.convertInterpol(matrix);
        BacaTulisMatrix.tulis(mHasil);
        mHasil = Gauss.jordan(mHasil);
        float[] mVar = new float[mHasil.length];
        BacaTulisMatrix.tulis(mHasil);
        for(i=0;i<mHasil.length;i++){
            mVar[i] = mHasil[i][mHasil[0].length-1];
        }
        
        return mVar;
    }

    public static float taksir(float[] matrix,float taksiran){
        int i;
        float hasil = 0;
        for(i=0;i<matrix.length;i++){
            hasil = hasil + (matrix[i]*BacaInterpolasi.pow(taksiran,i));
        }
        return hasil;
    }

}
