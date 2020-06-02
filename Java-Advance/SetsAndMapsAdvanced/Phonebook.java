package SoftUni.JavaAdvance.SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phoneBook = new HashMap<>();

        String line = "";

        while(!(line=scanner.nextLine()).equals("search")){
            String[] tokens = line.split("-");

            phoneBook.put(tokens[0],tokens[1]);
        }

        while(!(line=scanner.nextLine()).equals("stop")) {
            if (phoneBook.containsKey(line)) {
                System.out.printf("%s -> %s%n", line, phoneBook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.%n", line);
            }
        }
    }
}
