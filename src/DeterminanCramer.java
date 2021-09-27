public class DeterminanCramer {
    public static float det(float[][] matrix){
        float determinan = 0;
        int row,col,rowIn,i,j;
        row = 0;
        float[][] tmp = new float[matrix.length-1][matrix[0].length-1];
        if(matrix.length == 1){
            return matrix[0][0];
        }else if(matrix.length == 2){
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }else{
            while(row<matrix.length){
                i = 0;
                rowIn = 0;
                while(i<matrix.length){
                    col = 0;
                    j = 0;
                    while(j<matrix[0].length){
                        if(i != row && j != 0){
                            tmp[rowIn][col] = matrix[i][j];
                            col++;
                        }
                        j++;
                    }
                    if(i!=row){
                        rowIn++;
                    }
                    i++;
                }
                if(row%2 == 0){
                    determinan = determinan + (1)*DeterminanCramer.det(tmp)*matrix[row][0]; 
                }else{
                    determinan = determinan + (-1)*DeterminanCramer.det(tmp)*matrix[row][0];
                }
                row++;
            }

        }
        return determinan;
    }
}
