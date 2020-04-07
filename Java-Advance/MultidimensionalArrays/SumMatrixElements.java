package SoftUni.JavaAdvance;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        final int rows = Integer.parseInt(input[0]); //will get the dimensions of the matrix in a format :{rows, columns}.
        final int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] values = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);

                sum += matrix[row][col];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);

    }
}
