public class determinanKofaktor {
    public static float detKofaktor(float matrix[][]){
        int i,j,k,m,n;
        float temp[][] = new float [matrix.length-1][matrix.length-1];
        float result;
        result = 0;

        if (matrix.length == 1){
            return (matrix[0][0]);
        }

        else if (matrix.length==2){
            return (matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0]);
        }

        else {
            for (i=0; i<matrix.length; i++){
                m=0;
                for (j=0; j<matrix.length; j++){
                    n=0;
                    for (k=0; k<matrix.length; k++){
                        if (k!=i){
                            temp[m][n] = matrix[j][k];
                            n++;
                        }
                    }
                    if (j!=0){
                        m = m+1;
                    } 
                }
                if (i%2==0){
                    result += matrix[0][i]*detKofaktor(temp);
                }    
                else if (i%2==1){
                    result += matrix[0][i]*detKofaktor(temp)*-1;
                }
            }
        }
        return result;
    }
       

    public static void main(String[] args) {
        float matrix2[][] = {{4,2},{2,4}};
        float result;
        result = detKofaktor(matrix2);
        System.out.print(result);
    }
}
