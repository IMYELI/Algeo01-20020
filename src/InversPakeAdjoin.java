public class InversPakeAdjoin {
    public static double[][] InversAdjoin(double[][] matrix,double determinan) {
        int row ,col,rowIn,colIn,i,j;
        double[][] tmp2 = BacaTulisMatrix.copy(matrix);
        double[][] tmp = new double[matrix.length-1][matrix[0].length-1];
        if(matrix.length == 1){
            tmp2[0][0] = 1/matrix[0][0];
            return tmp2;
        }
        //MEMBUAT ADJOIN
        for(row=0;row<matrix.length;row++){
            for(col=0;col<matrix[0].length;col++){
                rowIn = 0;
                for(i=0;i<matrix.length;i++){
                    colIn = 0;
                    for(j=0;j<matrix[0].length;j++){
                        if(i != row && j != col){
                            tmp[rowIn][colIn] = matrix[i][j];
                            colIn++;
                            if(colIn == tmp.length){
                                rowIn++;
                            }
                        }

                    }

                }
                if((row+col)%2 == 0){
                    tmp2[row][col] = determinanCramer.detKofaktor(tmp);
                }else{
                    tmp2[row][col] = determinanCramer.detKofaktor(tmp)*(-1);
                }

            }

        }
        matrix = BacaTulisMatrix.transpose(tmp2);
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                matrix[i][j] /= determinan;
            }
        }
        return matrix;
    }
}


