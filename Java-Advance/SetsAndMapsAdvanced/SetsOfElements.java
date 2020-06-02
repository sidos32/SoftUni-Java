package SoftUni.JavaAdvance.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int setOneSize = Integer.parseInt(input[0]);
        int setTwoSize = Integer.parseInt(input[1]);

        Set<Integer>setOne = new LinkedHashSet<>();
        Set<Integer>setTwo = new LinkedHashSet<>();

        for (int i = 0; i < setOneSize; i++) {
            setOne.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < setTwoSize; i++) {
            setTwo.add(Integer.parseInt(scanner.nextLine()));
        }

        setOne.retainAll(setTwo);

        for (var num:setOne) {
            System.out.print(num + " ");
        }

    }
}
