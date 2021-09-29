public class IdentitasGenerator {
    public static double[][] generate(int m){
        double[][] mId = new double[m][m];
        int i,j;
        for(i = 0;i<m;i++){
            for(j=0;j<m;j++){
                if(i==j){
                    mId[i][j] = 1;
                }else{
                    mId[i][j] = 0;
                }
            }
        }
        return mId;
    }
}
