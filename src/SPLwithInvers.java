public class SPLwithInvers {

    public static void SPLInvers(float[][] matrixA, float[] matrixB) {
        boolean isSquare = true;
        int row = matrixA.length, col = matrixA[0].length;

        if (row != col) {
            isSquare = false;
        }

        if (isSquare) {

        } else {
            System.out.println("Tidak bisa diselesaikan dengan cara ini silakan gunakan cara lain");
            MainMenu();
        }
    }
}