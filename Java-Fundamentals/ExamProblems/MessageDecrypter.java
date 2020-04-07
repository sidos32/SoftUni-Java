package SoftUni.Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String regex = "^([$%])(?<command>[A-Z][a-z]{3,})\\1: " +
                "\\[(?<num1>[0-9]+)\\]\\|\\[(?<num2>[0-9]+)\\]\\|\\[(?<num3>[0-9]+)\\]\\|$";

        int numOfMessages = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numOfMessages; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String action = matcher.group("command");
                char firstLatter = (char) Integer.parseInt(matcher.group("num1"));
                char secondLatter = (char) Integer.parseInt(matcher.group("num2"));
                char thirdLatter = (char) Integer.parseInt(matcher.group("num3"));

                String message = action + ": " +
                        firstLatter + secondLatter + thirdLatter;
                System.out.println(message);
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
