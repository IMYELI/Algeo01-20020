public class InverswithAdjoin {
    public static float[][] InversAdjoin(float[][] matrix) {
        int row ,col,rowIn,colIn;
        float[][] tmp2 = BacaTulisMatrix.copy(matrix);
        float[][] tmp = new float[matrix.length-1][matrix[0].length-1];

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
                System.out.println();
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