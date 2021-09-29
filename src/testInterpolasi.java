import java.lang.Math;

public class testInterpolasi{
    public static void main(String[] args){
        System.out.println("Nomor 6a");
        int i,j,k;
        int balik = 1;
        float[][] matrix = {{(float)0.1,(float)0.003},
                            {(float)0.3,(float)0.067},
                            {(float)0.5,(float)0.148},
                            {(float)0.7,(float)0.248},
                            {(float)0.9,(float)0.370},
                            {(float)1.1,(float)0.518},
                            {(float)1.3,(float)0.697}};
        float raw[] = InterpolasiPolinom.interpolasi(matrix);
        float[] expResult = {(float)0.0329,(float)0.171,(float)0.337,(float)0.677};
        float result[] = new float[4];
        float soal[] = {(float)0.2,(float)0.55,(float)0.85,(float)1.28};
        float temp;
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
        float[][] matrix2 = {{(float)6.567,12624},
                            {(float)7,21807},
                            {(float)7.258,38391},
                            {(float)7.451,54517},
                            {(float)7.839,28228},
                            {(float)8.161,35764},
                            {(float)8.484,20813},
                            {(float)8.709,12408},
                            {(float)9,10534}};
        float raw2[] = InterpolasiPolinom.interpolasi(matrix2);
        float[] expResult2 = {(float)53537.7,(float)36344.3,(float)-659127,(float)27751.9};
        float result2[] = new float[4];
        float soal2[] = {(float)7.516,(float)8.322,(float)9.166,(float)8};
        //masukan user adalah tanggal 31 Juli 2021 (tanggal file dibuat)
        float temp2;
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
        float[][] matrix3 = {{(float)0.4,(float)0.4188},
                             {(float)0.8,(float)0.5071},
                             {(float)1.2,(float)0.5609},
                             {(float)1.6,(float)0.5836},
                             {(float)2.0,(float)0.5766}};
        float result3[] = InterpolasiPolinom.interpolasi(matrix3);
        float[] expResult3 = {(float)0.2906,(float)0.376125,(float)-0.147292,(float)0.021875,(float)-0.003255};

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