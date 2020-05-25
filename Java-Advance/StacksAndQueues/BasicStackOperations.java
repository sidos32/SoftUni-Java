package SoftUni.JavaAdvance.StacksAndQueues;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer>numbers = new ArrayDeque<>();

        int n = input[0];
        int numbersToRemove = input[1];
        int numToCheck = input[2];

        for (int i = 0; i < n; i++) {
            numbers.push(scanner.nextInt());
        }

        for (int i = 0; i < numbersToRemove; i++) {
            numbers.pop();
        }

        if(numbers.contains(numToCheck)){
            System.out.println("true");
        }else {

            System.out.println(numbers.stream().min(Integer::compareTo).orElse(0));

            }
        }


    }