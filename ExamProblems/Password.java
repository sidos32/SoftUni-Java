package SoftUni.Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPasswords = Integer.parseInt(scanner.nextLine());

        final String validPasswordRegex = "(.+)>(?<numbers>[0-9]+)\\|(?<lowerCaseW>[a-z]+)" +
                "\\|(?<upperCaseW>[A-Z]+)\\|(?<symbols>[^<>]+)<\\1$";
        Pattern pattern = Pattern.compile(validPasswordRegex);

        for (int i = 0; i < numOfPasswords; i++) {
            String password = scanner.nextLine();

            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                String numbers = matcher.group("numbers");
                String lowerCaseWord = matcher.group("lowerCaseW");
                String upperCaseWord = matcher.group("upperCaseW");
                String symbols = matcher.group("symbols");

                System.out.printf("Password: %s%s%s%s%n", numbers, lowerCaseWord, upperCaseWord, symbols);

            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
