public class isLineZero {
    public static int isZero(double matrix[][]){
        int i,j,result,count;
        
        result = 0;

        for (i=0; i<matrix.length; i++){
            count = 0;
            for (j=0; j<matrix.length; j++){
                if (matrix[i][j]==0){
                    count++;
                }
            }
            if (count == matrix.length){
                result = 1;
            }
        }

        for (i=0; i<matrix.length; i++){
            count = 0;
            for (j=0; j<matrix.length; j++){
                if (matrix[j][i]==0){
                    count++;
                }
            }
            if (count == matrix.length){
                result = 1;
            }
        }

        return result;
    }
}


