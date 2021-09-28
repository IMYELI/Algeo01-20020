public class isRowSame {
    public static int isSame(float matrix[][]){
        int i,j,k,result,count;
        
        result = 0;

        for (k=0; k<(matrix.length); k++){
            for (i=k+1; i<matrix.length; i++){
                count = 0;
                for (j=0; j<matrix.length; j++){
                    if(matrix[k][j]==matrix[i][j]){
                        count ++;
                    }
                }
                if (count == matrix.length){
                    result = 1;
                }
            }
        }
        return result;
    }
}
