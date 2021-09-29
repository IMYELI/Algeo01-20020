public class determinanGauss {
    public static double detGauss (double matrix[][]){
        int i,j,k,l,m,cont,same,iszero;
        double temparr[][];
        double result,temp;

        temparr = sortMatrixRow.sortMatrix(matrix);
        result = 1;
        cont = 0;
        same = isRowSame.isSame(matrix);
        

        for (m=0; m<matrix.length; m++){
            if (temparr[matrix.length-1][m] != 0){
                cont = 1;
            }
        }
        
        if (cont == 0 || same == 1){
            result = 0;
        }

        else if (cont == 1 && same == 0){
            for (k=0; k<(matrix.length); k++){
                for (i=k+1; i<matrix.length; i++){
                    temp = matrix[i][k];
                    for (j=k; j<matrix.length; j++){
                        iszero = isLineZero.isZero(matrix);
                        if (iszero == 1){
                            result = 0;
                            return result;
                        } 
                        else {
                            temparr[i][j] = temparr[i][j] - (matrix[k][j] * temp / matrix[k][k]);
                        }
                    }
                }
            }

            for(l=0; l<matrix.length; l++){
                result = result * matrix[l][l];
            }
        }

        if (result == -0.0){
            result = 0;
        }
        return result;
        
    }
}


