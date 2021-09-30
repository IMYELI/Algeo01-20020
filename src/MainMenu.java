import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
class MainMenu{
    public static void main(String[] args){
        boolean keluar = false;
        double[][] matrix;
        double hasilDet,taksiran,hasil;
        Scanner sc = new Scanner(System.in);
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        int m,n,flag,i;
        boolean stop = false;
        String path = System.getProperty("user.dir");
        Path dir = Paths.get(path).getParent();
        dir = Paths.get(dir.toString(),"test");
        LocalDateTime tanggal = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("-yyyy-MM-dd-HH-mm-ss");
        String waktu = tanggal.format(formatDateTime);
        path = dir + "\\rekaman" + waktu + ".txt";
        try{
            FileWriter rekam = new FileWriter(path);
            
        while (!keluar){
            
            System.out.println("MAIN MENU: ");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi polinom");
            System.out.println("5. Regresi linier berganda");
            System.out.println("6. Keluar");
            System.out.println();
            System.out.print("Pilihan menu: ");

            int pilMenu = sc.nextInt();
            if(pilMenu == 1){
                System.out.print("Masukan besar matrix m x n(input m dan n terpisah): ");
                m = sc.nextInt();
                n = sc.nextInt();
                bacaMat.setMat(m, n);
                matrix = bacaMat.baca(sc);
                rekam.write("Matrix yang diinput: \n");
                BacaTulisMatrix.rekamMatrixToString(matrix, rekam);
                System.out.println("\nMatrix yang anda input: ");
                BacaTulisMatrix.tulis(matrix);
                rekam.write("\n\n");
                double[] mVar = SPLMenu.invers(matrix, sc, rekam);


            }else if(pilMenu == 2){
                System.out.print("Masukan besar matrix m x m: ");
                m = sc.nextInt();
                bacaMat.setMatSquare(m);
                matrix = bacaMat.baca(sc);
                rekam.write("Matrix yang diinput: \n");
                BacaTulisMatrix.rekamMatrixToString(matrix, rekam);
                System.out.println("\nMatrix yang anda input: ");
                BacaTulisMatrix.tulis(matrix);
                hasilDet = determinanMatrix.determinan(matrix,sc);
                rekam.write("\n\nDeterminan dari matrix: \n");
                rekam.write(Double.toString(hasilDet));
                rekam.write("\n\n\n");

            }else if(pilMenu == 3){
                System.out.print("Masukan besar matrix m x m: ");
                m = sc.nextInt();
                bacaMat.setMatSquare(m);
                matrix = bacaMat.baca(sc);
                rekam.write("Matrix yang diinput: \n");
                BacaTulisMatrix.rekamMatrixToString(matrix, rekam);
                System.out.println("\nMatrix yang anda input: ");
                BacaTulisMatrix.tulis(matrix);
                matrix = inversMatrix.invers(matrix,sc,rekam);
                rekam.write("\n\n\n");
                
                
            }else if(pilMenu == 4){
                matrix = BacaInterpolasi.baca(sc);
                BacaTulisMatrix.rekamMatrixToString(matrix, rekam);
                rekam.write("Matrix yang diinput: \n");
                double[] mVar = InterpolasiPolinom.interpolasi(matrix); 
                System.out.println("Persamaan polinomial yang terbentuk: ");
                rekam.write("\n\nPersamaan polinomial yang terbentuk:\n");
                BacaInterpolasi.tulisRekam(mVar,rekam);
                BacaInterpolasi.tulis(mVar);
                System.out.println();
                rekam.write("\n\nHasil taksir: \n");
                while(!stop){
                    System.out.print("Masukan nilai yang ingin ditaksir: ");
                    taksiran = sc.nextDouble();
                    hasil = InterpolasiPolinom.taksir(mVar, taksiran);
                    rekam.write("F(" + Double.toString(taksiran) + ") = " + Double.toString(hasil) + "\n");
                    System.out.println("Hasil taksiran:");
                    System.out.printf("%f",hasil);
                    System.out.println();
                    System.out.print("Apakah anda masih ingin menaksir?(input 1 jika ya, input sembarang jika tidak): ");
                    flag = sc.nextInt();
                    if(flag != 1){
                        stop = true;
                    }
                    System.out.println();

                }
                rekam.write("\n\n\n");
                

            }else if(pilMenu == 5){
                matrix = BacaRegresi.baca(sc);
                rekam.write("Matrix yang diinput: \n");
                BacaTulisMatrix.rekamMatrixToString(matrix, rekam);
                matrix = BacaRegresi.convertKali(matrix);
                matrix = Gauss.jordan(matrix);
                System.out.println("Hasil regresi matrix: ");
                BacaRegresi.tulis(matrix);
                rekam.write("\n\nHasil regresi:\n");
                BacaRegresi.tulisRekam(matrix,rekam);
                rekam.write("\n\n");
                double[] mVar = BacaRegresi.ubah1D(matrix);
                System.out.println();
                double[] taksiranRegresi = new double[mVar.length-1];
                while(!stop){
                    System.out.print("Masukan nilai yang ingin ditaksir: \n");
                    for(i=0;i<mVar.length-1;i++){
                        taksiranRegresi[i] = sc.nextDouble();
                    }
                    hasil = BacaRegresi.taksir(mVar, taksiranRegresi);
                    BacaRegresi.rekamHasil(taksiranRegresi,rekam);
                    rekam.write(Double.toString(hasil));
                    rekam.write("\n");
                    System.out.println("Hasil taksiran:");
                    System.out.printf("%f",hasil);
                    System.out.println();
                    System.out.print("Apakah anda masih ingin menaksir?(input 1 jika ya, input sembarang jika tidak): ");
                    flag = sc.nextInt();
                    if(flag != 1){
                        stop = true;
                    }
                    System.out.println();
                }
                rekam.write("\n\n\n");
            }else if(pilMenu == 6){
                keluar = true;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }      
            rekam.close();
        }
        }catch(IOException e){
            
            System.out.println("\nAda error\n");
            System.out.println(e);
        }
        sc.close();
        

    }
}

