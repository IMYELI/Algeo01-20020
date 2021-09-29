import java.util.Scanner;
class MainMenu{
    public static void main(String[] args){
        boolean keluar = false;
        double[][] matrix;
        double hasilDet,taksiran,hasil;
        Scanner sc = new Scanner(System.in);
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        int m,n;
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
                
            }else if(pilMenu == 2){
                System.out.print("Masukan besar matrix m x m: ");
                m = sc.nextInt();
                bacaMat.setMatSquare(m);
                matrix = bacaMat.baca(sc);
                System.out.println("\nMatrix yang anda input: ");
                BacaTulisMatrix.tulis(matrix);
                hasilDet = determinanMatrix.determinan(matrix,sc);

            }else if(pilMenu == 3){
                System.out.print("Masukan besar matrix m x m: ");
                m = sc.nextInt();
                bacaMat.setMatSquare(m);
                matrix = bacaMat.baca(sc);
                System.out.println("\nMatrix yang anda input: ");
                BacaTulisMatrix.tulis(matrix);
                matrix = inversMatrix.invers(matrix,sc);
                System.out.println("\nMatrix hasil invers: ");
                BacaTulisMatrix.tulis(matrix);  
                
            }else if(pilMenu == 4){
                matrix = BacaInterpolasi.baca(sc);
                double[] mVar = InterpolasiPolinom.interpolasi(matrix); 
                System.out.println("Persamaan polinomial yang terbentuk: ");
                BacaInterpolasi.tulis(mVar);
                System.out.println();
                System.out.print("Masukan nilai yang ingin ditaksir: ");
                taksiran = sc.nextDouble();
                hasil = InterpolasiPolinom.taksir(mVar, taksiran);
                System.out.println("Hasil taksiran:");
                System.out.printf("%f",hasil);
                System.out.println();

            }else if(pilMenu == 5){
                matrix = BacaRegresi.baca(sc);
                matrix = BacaRegresi.convertKali(matrix);
                matrix = Gauss.jordan(matrix);
                System.out.println("Hasil regresi matrix: ");
                BacaRegresi.tulis(matrix);
                System.out.println();
                
            }else if(pilMenu == 6){
                keluar = true;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }      
            
        }
        sc.close();
        

    }
}

