public class sortMatrixRow {
    public static double[][] sortMatrix(double matrix[][]){
        //sort matrix berdasarkan jumlah 0 didepannya
            int i,j,k,l,m,temp;
            int temparr[] = new int[matrix.length];
            double tempval;
            
            for(i=0; i<matrix.length; i++){
                temp = 0;
                temparr[i] = 0;
                for(j=0; j<matrix.length; j++){
                    if(matrix[i][j]!=0){
                        temparr[i]=temp;
                        j=matrix.length;
                    } else {
                        temp++;
                        temparr[i]=temp;
                    }
                }
            }
    
            for(k=0; k<matrix.length; k++){
                for(l=k; l<matrix.length; l++){
                    if(temparr[k]>temparr[l]){
                        for(m=0; m<matrix.length; m++){
                            tempval = matrix[k][m];
                            matrix[k][m] = matrix[l][m];
                            matrix[l][m] = tempval*-1;
                        }
                        temp = temparr[k];
                        temparr[k] = temparr[l];
                        temparr[l] = temp;
                    }
                }
            }
    
            return matrix;
        }
}
