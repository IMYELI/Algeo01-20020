public class IdentitasGenerator {
    public static float[][] generate(int m){
        float[][] mId = new float[m][m];
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
