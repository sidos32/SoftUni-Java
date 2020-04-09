package SoftUni.JavaAdvance.MultidimensionalArrays;

import java.util.Scanner;

public class FillMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        if(pattern.toUpperCase().equals("A")){
            matrixPatternA(n);
        }else {
            matrixPatternB(n);
        }
    }

    private static void matrixPatternA(int n) {
        int[][] matrixA = new int[n][n];
        int counter = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrixA[row][col] = counter;
                counter++;
            }
        }
        printMatrix(matrixA);
    }


    private static void matrixPatternB(int n) {
        int[][] matrixB = new int[n][n];
        int counter = 1;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {

                for (int row = 0; row < n; row++) {
                    matrixB[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrixB[row][col] = counter;
                    counter++;
                }

            }


        }
        printMatrix(matrixB);
    }

    private static void printMatrix(int[][] matrixB) {
        for (int[] row : matrixB) {
            for (int col : row) {
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }

}
