package SoftUni.Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        final String regex = "([@*])(?<tag>[A-Z][a-z]{3,})\\1: \\[(?<charOne>[A-Za-z])\\]\\|\\[" +
                "(?<charTwo>[A-Za-z])\\]\\|\\[(?<charThree>[A-Za-z])\\]\\|$";

        int numOfMessages = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numOfMessages; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String action = matcher.group("tag");
                int firstLatter = matcher.group("charOne").charAt(0);
                int secondLatter = matcher.group("charTwo").charAt(0);
                int thirdLatter = matcher.group("charThree").charAt(0);

                System.out.printf("%s: %d %d %d%n",action,firstLatter,secondLatter,thirdLatter);
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
