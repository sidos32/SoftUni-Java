package SoftUni.JavaAdvance.SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<Character, Integer> dictionary = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char sym = input.charAt(i);

            if (!dictionary.containsKey(sym)) {
                dictionary.put(sym, 1);
            } else {
                int count = dictionary.get(sym) + 1;
                dictionary.put(sym, count);
            }
        }

        for (var entry : dictionary.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
