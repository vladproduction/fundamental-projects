package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int rowsMatrix1 = matrix1.length;
        int columnsMatrix1 = matrix1[0].length;
        int rowsMatrix2 = matrix2.length;
        int columnsMatrix2  = matrix2[0].length;

        //rules:
        //1) the number of columns matrix1 must equal the number of rows matrix2; (columnsMatrix1 == rowsMatrix2)
        //2) the resulting matrix will have dimensions equal to the number of rows matrix1 and the number of columns matrix2; [rowsMatrix1][columnsMatrix2]

        int[][] result = new int[rowsMatrix1][columnsMatrix2];

        if(columnsMatrix1 != rowsMatrix2){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < rowsMatrix1; i++) {
            for (int j = 0; j < columnsMatrix2; j++) {
                for (int k = 0; k < columnsMatrix1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
