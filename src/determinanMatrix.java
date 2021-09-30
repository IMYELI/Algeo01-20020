import java.util.Scanner;
public class determinanMatrix {
    public static double determinan(double[][] matrix, Scanner read){
        int pilMenu;
        double result = 0;
        double[][] temp = BacaTulisMatrix.copy(matrix);
        boolean kembali = false;
        while(!kembali){
            System.out.println("Pilihan menu determinan: ");
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode kofaktor");
            System.out.println("3. Kembali ke menu utama");
            System.out.print("Pilihan menu: ");
            pilMenu = read.nextInt();
            if(pilMenu == 1){
                int i,j,k,l,m,cont,same,iszero;
                double temparr[][];
                double tempval;
        
                temparr = sortMatrixRow.sortMatrix(temp);
                result = 1;
                cont = 0;
                same = isRowSame.isSame(temp);
                
        
                for (m=0; m<temp.length; m++){
                    if (temparr[temp.length-1][m] != 0){
                        cont = 1;
                    }
                }
                
                if (cont == 0 || same == 1){
                    result = 0;
                }
        
                else if (cont == 1 && same == 0){
                    for (k=0; k<(temp.length); k++){
                        for (i=k+1; i<temp.length; i++){
                            tempval = temp[i][k];
                            for (j=k; j<temp.length; j++){
                                iszero = isLineZero.isZero(temp);
                                if (iszero == 1){
                                    result = 0;
                                    i = temp.length;
                                    j = temp.length;
                                    k = temp.length;
                                } 
                                else {
                                    temparr[i][j] = temparr[i][j] - (temp[k][j] * tempval / temp[k][k]);
                                }
                            }
                        }
                    }
        
                    for(l=0; l<temp.length; l++){
                        result = result * temp[l][l];
                    }
                }
        
                if (result == -0.0){
                    result = 0;
                }
                
                System.out.println(result);
            }

            else if (pilMenu == 2){
                int i,j,k,m,n;
                double temp2[][] = new double [temp.length-1][temp.length-1];
                result = 0;
        
                if (temp.length == 1){
                    result = temp[0][0];


                }
        
                else if (temp.length==2){
                    result = (temp[0][0]*temp[1][1]-temp[0][1]*temp[1][0]);


                }
        
                else {
                    for (i=0; i<temp.length; i++){
                        m=0;
                        for (j=0; j<temp.length; j++){
                            n=0;
                            for (k=0; k<temp.length; k++){
                                if (k!=i){
                                    temp2[m][n] = temp[j][k];
                                    n++;
                                }
                            }
                            if (j!=0){
                                m = m+1;
                            } 
                        }
                        if (i%2==0){
                            result += temp[0][i]*determinanCramer.detKofaktor(temp2);
                        }    
                        else if (i%2==1){
                            result += temp[0][i]*determinanCramer.detKofaktor(temp2)*-1;
                        }
                    }
                }

                System.out.println(result);
            } 

            else if(pilMenu == 3){
                kembali = true;
                return result;
            
            }
            else{
                System.out.println("Pilihan menu tidak valid");
            }

            }
            return result;
        }
    }
    


