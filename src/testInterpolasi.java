import java.lang.Math;

public class testInterpolasi{
    public static void main(String[] args){
        System.out.println("Nomor 6a");
        int i,j,k;
        int balik = 1;
        double[][] matrix = {{0.1,0.003},
                            {0.3,0.067},
                            {0.5,0.148},
                            {0.7,0.248},
                            {0.9,0.370},
                            {1.1,0.518},
                            {1.3,0.697}};
        double raw[] = InterpolasiPolinom.interpolasi(matrix);
        double[] expResult = {0.0329,0.171,0.337,0.677};
        double result[] = new double[4];
        double soal[] = {0.2,0.55,0.85,1.28};
        double temp;
        System.out.println("");

        for (i=0; i<result.length; i++){
            temp=0;
            for (j=0; j<raw.length; j++){
                temp += raw[j]*Math.pow(soal[i],j);
            }
            result[i] = temp;
        }

        for (k=0; k<result.length; k++){
            if (result[k]<0){
                if (result[k]<1.05*expResult[k] || result[k]>0.95*expResult[k]){
                    balik = 0;
                }
            } else {
                if (result[k]>1.05*expResult[k] || result[k]<0.95*expResult[k]){
                    balik = 0;
                }
            }
        }
       
        System.out.print("f(x) untuk (x = 0.2) : " );
        System.out.println(result[0]);
        System.out.print("f(x) untuk (x = 0.55) : " );
        System.out.println(result[1]);
        System.out.print("f(x) untuk (x = 0.85) : " );
        System.out.println(result[2]);
        System.out.print("f(x) untuk (x = 1.28) : " );
        System.out.println(result[3]);
        
        if (balik == 1){
            System.out.println("jawaban benar");
        } else {
            System.out.println("jawaban salah");
        }

        System.out.println("");
        System.out.println("Nomor 6b");
        int m,n,o;
        int balik2 = 1;
        double[][] matrix2 = {{6.567,12624},
                            {7,21807},
                            {7.258,38391},
                            {7.451,54517},
                            {7.839,28228},
                            {8.161,35764},
                            {8.484,20813},
                            {8.709,12408},
                            {9,10534}};
        double raw2[] = InterpolasiPolinom.interpolasi(matrix2);
        double[] expResult2 = {53537.7,36344.3,-659127,27751.9};
        double result2[] = new double[4];
        double soal2[] = {7.516,8.322,9.166,8};
        //masukan user adalah tanggal 31 Juli 2021 (tanggal file dibuat)
        double temp2;
        System.out.println("");

        for (m=0; m<result2.length; m++){
            temp2=0;
            for (n=0; n<raw2.length; n++){
                temp2 += raw2[n]*Math.pow(soal2[m],n);
            }
            result2[m] = temp2;
        }

        for (o=0; o<result2.length; o++){
            if(result2[o]>expResult2[o]+100 || result2[o]<expResult2[o]-100){
                balik2 = 0;
            }
        }

        System.out.print("nilai untuk 16/07/2021 : " );
        System.out.println(result2[0]);
        System.out.print("nilai untuk 10/08/2021 : " );
        System.out.println(result2[1]);
        System.out.print("nilai untuk 05/09/2021 : " );
        System.out.println(result2[2]);
        System.out.print("nilai untuk 31/07/2021 : " );
        System.out.println(result2[3]);

        if (balik2 == 1){
            System.out.println("jawaban benar");
        } else {
            System.out.println("jawaban salah");
        }

        System.out.println("");
        System.out.println("Nomor 6c");
        int x,y;
        int balik3 = 1;
        //melakukan tes untuk interpolasi derajat 5 seperti di soal
        double[][] matrix3 = {{0.4,0.4188},
                             {0.8,0.5071},
                             {1.2,0.5609},
                             {1.6,0.5836},
                             {2.0,0.5766}};
        double result3[] = InterpolasiPolinom.interpolasi(matrix3);
        double[] expResult3 = {0.2906,0.376125,-0.147292,0.021875,-0.003255};

        for (x=0; x<result3.length; x++){
            if (result3[x]<0){
                if (result3[x]<1.05*expResult3[x] || result3[x]>0.95*expResult3[x]){
                    balik3 = 0;
                }
            } else {
                if (result3[x]>1.05*expResult3[x] || result3[x]<0.95*expResult3[x]){
                    balik3 = 0;
                }
            }
        }
        System.out.print("nilai untuk angka awal = ");
        System.out.println(result3[0]);
        for (y=1; y<result3.length; y++){
            System.out.print("nilai variabel pangkat " + y + " = ");
            System.out.println(result3[y]);
        }

        if (balik3 == 1){
            System.out.println("jawaban benar");
        } else {
            System.out.println("jawaban salah");
        }
    }
}