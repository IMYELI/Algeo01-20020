import java.util.Scanner; 
import java.io.FileWriter;
import java.io.IOException;
public class SPLMenu{
    public static double[] invers(double[][] matrix, Scanner read, FileWriter rekam){
        int pilMenu, sum = OperasiMatrix.getRow(matrix);
        boolean kembali = false;
        double[] solusiSPL = new double [sum];
        try{

        while(!kembali){
            System.out.println("Pilihan menu invers: ");
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode cramer");
            System.out.println("4. Metode invers");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilihan menu: ");
            pilMenu = read.nextInt();

            // Metode Gauss
            if(pilMenu == 1){
                int row = OperasiMatrix.getRow(matrix), col = OperasiMatrix.getCol(matrix);

                double[][] matrixHasil = Gauss.jordan(matrix);
                double[][] matrixCek = OperasiMatrix.makeMatrixA(matrixHasil, row, col-1);
        
                int solusi = 1;
        
                if (OperasiMatrix.isNotSolution(matrixCek)) {
                    solusi = 2;
                } else if (!(OperasiMatrix.isSquare(matrixCek))) {
                    solusi = 3;
                }
        
                if (solusi == 1) {
                    double solusiX[] = HasilSPL.HasilUnikGauss(matrixHasil);
                    
                    rekam.write("Solusi dari persamaan: \n\n");
                    System.out.println("Solusinya sebagai berikut : ");
        
                    int idxCol;           
                    for (idxCol = 0; idxCol < col - 1; idxCol++) {
                        System.out.format("X%d = %.2f %n", (idxCol+1), solusiX[idxCol]);

                        rekam.write("x" + Integer.toString(idxCol+1) + Double.toString(solusiX[idxCol]) + "\n");
                        
                    }
                } else if (solusi == 2) {
                    System.out.println("Tidak ada Solusi");
                    rekam.write("Tidak ada solusi");
                }  else if (solusi == 3) {
                    String[] solusiX = HasilSPL.HasilGakUnik(matrixHasil);
                    rekam.write("Solusi dari persamaan: \n\n");
                    System.out.println("Solusinya sebagai berikut : ");
        
                    int idxCol;
                    for (idxCol = 0; idxCol < col - 1; idxCol++) {
                        System.out.format("X%d = %s %n", (idxCol+1), solusiX[idxCol]);
                        rekam.write("X" + Integer.toString(idxCol+1) + " = " + solusiX[idxCol] + "\n");
                    }
                }
            // Metode Gauss Jordan
            }else if(pilMenu == 2){
                int row = OperasiMatrix.getRow(matrix), col = OperasiMatrix.getCol(matrix);

                double[][] matrixHasil = Gauss.jordan(matrix);
                double[][] matrixCek = OperasiMatrix.makeMatrixA(matrixHasil, row, col-1);
        
                int solusi = 1;
        
                if (OperasiMatrix.isNotSolution(matrixCek)) {
                    solusi = 2;
                } else if (!(OperasiMatrix.isSquare(matrixCek))) {
                    solusi = 3;
                }
        
                if (solusi == 1) {
                    double solusiX[] = HasilSPL.HasilUnikJordan(matrixHasil);
                    
                    System.out.println("Solusinya sebagai berikut : ");
                    rekam.write("Solusi dari persamaan: \n\n");
                    int idxCol;
                    for (idxCol = 0; idxCol < col - 1; idxCol++) {
                        System.out.format("X%d = %.2f %n", (idxCol+1), solusiX[idxCol]);
                        rekam.write("X" + Integer.toString(idxCol + 1) + " = " + Double.toString(solusiX[idxCol]) + "\n");
                    }
                } else if (solusi == 2) {
                    System.out.println("Tidak ada Solusi");
                    rekam.write("Tidak ada solusi\n");
                } else if (solusi == 3) {
                    String[] solusiX = HasilSPL.HasilGakUnik(matrixHasil);
                    rekam.write("Solusi dari persamaan: \n\n");
                    System.out.println("Solusinya sebagai berikut : ");
                    
                    int idxCol;
                    for (idxCol = 0; idxCol < col - 1; idxCol++) {
                        System.out.format("X%d = %s %n", (idxCol+1), solusiX[idxCol]);
                        rekam.write("X" + Integer.toString(idxCol + 1) + " = " + solusiX[idxCol] + "\n");
                    }
                }
            // Metode Cramer
            } else if(pilMenu == 3) {
                int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix) - 1;

                double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
                double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);
        
                int colA = OperasiMatrix.getCol(matrixA);
                double determinan = determinanCramer.detKofaktor(matrixA);
            
                if (OperasiMatrix.isSquare(matrixA) && determinan != 0) {
                    solusiSPL = HasilSPL.HasilCramer(matrixA, matrixB, determinan);
                    int idxCol;
                    rekam.write("Solusi dari persamaan: \n\n");
                    System.out.println("Solusinya sebagai berikut : ");
                    for (idxCol = 0; idxCol < colA; idxCol++) {
                        rekam.write("X" + Integer.toString(idxCol + 1) + " = " + Double.toString(solusiSPL[idxCol]) + "\n");
                        System.out.format("X%d = %.2f", (idxCol+1), solusiSPL[idxCol]);
                        System.out.println();
                    }
                //Tidak bisa di kerjakan karena bukan matrix persegi
                } else {
                    System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain.");
                    rekam.write("Cara yang dipilih tidak bisa menyelesaikan persamaan. Mencoba cara lain...\n\n");
                }
            // Metoder Invers
            } else if(pilMenu == 4) {
                    int newRow = OperasiMatrix.getRow(matrix), newCol = OperasiMatrix.getCol(matrix)-1;
                    double[][] matrixA = OperasiMatrix.makeMatrixA(matrix, newRow, newCol);
                    double[][] matrixB = OperasiMatrix.makeMatrixB(matrix, newRow, newCol);
            
                    int rowA = OperasiMatrix.getRow(matrixA), colA = OperasiMatrix.getCol(matrixA);
                    int rowB = OperasiMatrix.getRow(matrixB);
                    
            
                    if (OperasiMatrix.isSquare(matrixA) && colA == rowB) {
                        boolean isNol = OperasiMatrix.isMatrixBNol(matrixB);
                        double determinan = determinanCramer.detKofaktor(matrixA);
                        //B matrix nol & determinan = 0
                        if (isNol && determinan == 0) {
                            System.out.println("Solusi tidak trivial, gunakan cara lain.");
                            rekam.write("Solusi tidak trivial, gunakan cara lain.\n");
                        //B bukan matrix nol & determinan = 0
                        } else if (!isNol && determinan == 0) {
                            System.out.println("Solusi tidak tunggal unik, gunakan cara lain.");
                            rekam.write("Solusi tidak tunggal unik, gunakan cara lain.\n");
                        } else if (!isNol && determinan != 0) {
                            solusiSPL = HasilSPL.HasilInvers(matrixA, matrixB, determinan);
                            int idxRow;
              
                            System.out.println("Solusinya sebagai berikut : ");
                            rekam.write("Solusi dari persamaan: \n\n");
                            for (idxRow = 0; idxRow < rowA; idxRow++) {
                                System.out.format("X%d = %.2f", (idxRow + 1), solusiSPL[idxRow]);
                                rekam.write("x" + Integer.toString(idxRow + 1) + " = " +solusiSPL[idxRow] + "\n");
                                System.out.println();
                            }
                        }
                    //bukan matrix square tidak bisa invers
                    } else {
                        System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
                        rekam.write("Cara yang dipilih tidak bisa menyelesaikan persamaan. Mencoba cara lain...\n\n");
                    }
            }

            else if(pilMenu == 5){
                kembali = true;
                return solusiSPL;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }
        }
        }catch(IOException e){

        }
        return solusiSPL;
    }
}