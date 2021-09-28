public class InterpolasiPolinom {
    public static float[] interpolasi(float[][] matrix){
        float[][] mHasil = new float[matrix.length][matrix.length+1];
        int i;
        mHasil = BacaInterpolasi.convertInterpol(matrix);
        BacaTulisMatrix.tulis(matrix);
        System.out.println();
        BacaTulisMatrix.tulis(mHasil);
        mHasil = Gauss.jordan(mHasil);
        float[] mVar = new float[mHasil.length];
        for(i=0;i<mHasil.length;i++){
            mVar[i] = mHasil[i][mHasil[0].length-1];
        }
        System.out.println("Persamaan polinomial yang terbentuk: ");
        for(i=0;i<mVar.length;i++){
            if(i == mVar.length){
                System.out.print(" = ");
            }
            System.out.printf("%fX%d",mVar[i],i);
            if(i!=mVar.length){
                System.out.print(" + ");
            }
        }
        return mVar;
    }

}
