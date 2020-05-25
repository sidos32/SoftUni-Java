package SoftUni.JavaAdvance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer>reversedNum = new ArrayDeque<>();

        for (int element: input) {
            reversedNum.push(element);
        }

        for (var element : reversedNum) {
            System.out.print(element + " ");
        }

    }
}
