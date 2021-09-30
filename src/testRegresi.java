public class testRegresi {
    public static void main(String[] args){
        System.out.println("Nomor 7");
        double[][] matrix = {{72.4, 41.6, 34.3, 35.1, 10.7, 12.9, 8.3, 20.1, 72.2, 24.0, 23.2, 47.4, 31.5, 10.6, 11.2, 73.3, 75.4, 96.6, 107.4, 54.9},
                            {76.3, 70.3, 77.1, 68.0, 79.0, 67.4, 66.8, 76.9, 77.7, 67.7, 76.8, 86.6, 76.9, 86.3, 86.0, 76.3, 77.9, 78.7, 86.8, 70.9},
                            {29.18, 29.35, 29.24, 29.27, 29.78, 29.39, 29.69, 29.48, 29.09, 29.6, 29.38, 29.35, 29.63, 29.56, 29.48, 29.4, 29.28, 29.29, 29.03, 29.37},
                            {0.9, 0.91, 0.96, 0.89, 1.0, 1.1, 1.15, 1.03, 0.77, 1.07, 1.07, 0.94, 1.1, 1.1, 1.1, 0.91, 0.87, 0.78, 0.82, 0.95}};

        int balik = 1;
        
        matrix = BacaRegresi.convertKali(matrix);
        matrix = Gauss.jordan(matrix);
        double[] mVar = BacaRegresi.ubah1D(matrix);
        System.out.println("Hasil regresi matrix: ");
        BacaRegresi.tulis(matrix);
        System.out.println("");
        double[] taksiranRegresi = {50,76.0,29.3};
        double expResult = 0.9416;
        double hasil = BacaRegresi.taksir(mVar, taksiranRegresi);
        System.out.print("hasil taksiran dari humidity 50%, suhu 76 F, dan tekanan udara 29.30 adalah = ");
        System.out.println(hasil);
        
        if (hasil<0){
            if (hasil<1.05*expResult || hasil>0.95*expResult){
                balik = 0;
            }
        } else {
            if (hasil>1.05*expResult || hasil<0.95*expResult){
                balik = 0;
            }
        }

        if (balik == 1){
            System.out.println("jawaban benar");
        } else {
            System.out.println("jawaban salah");
        }

    }
}
