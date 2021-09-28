public class SPLwithKofaktor {

    public static void SPLKofaktor(float[][] matrixA, float[] matrixB) {
        boolean isSquare = true;
        int row = matrixA.length, col = matrixA[0].length;

        if (row != col) {
            isSquare = false;
        }

        if (isSquare) {


        //Tidak bisa di kerjakan karena bukan matrix persegi
        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
        }
    }
}