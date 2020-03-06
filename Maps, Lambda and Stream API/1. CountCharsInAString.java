package SoftUni.Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> mapOfStrings = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch != 32) {

                mapOfStrings.putIfAbsent(ch, 0);


                mapOfStrings.put(ch, mapOfStrings.get(ch) + 1);
            }

        }

        mapOfStrings.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));


    }

}
