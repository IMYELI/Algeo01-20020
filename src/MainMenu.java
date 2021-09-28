import java.util.Scanner;
class MainMenu{
    public static void main(String[] args){
        boolean keluar = false;
        float[][] matrix;
        Scanner sc = new Scanner(System.in);
        BacaTulisMatrix bacaMat = new BacaTulisMatrix();
        int m;
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

            }else if(pilMenu == 3){
                System.out.print("Masukan besar matrix m x m: ");
                m = sc.nextInt();
                bacaMat.setMatSquare(m);
                matrix = bacaMat.baca(sc);
                System.out.println("\nMatrix yang anda input: ");
                BacaTulisMatrix.tulis(matrix);
                matrix = inversMatrix.invers(matrix,sc);  
                
            }else if(pilMenu == 4){

            }else if(pilMenu == 5){

            }else if(pilMenu == 6){
                keluar = true;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }      
            
        }
        sc.close();
        

    }
}