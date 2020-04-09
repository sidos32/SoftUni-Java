package SoftUni.JavaAdvance.MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];
        System.out.println();

        
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
            }
        }


        for (var row : matrix) {
            for (var col : row) {
                System.out.printf("%s ", col);
            }
            System.out.println();
        }


    }
}
