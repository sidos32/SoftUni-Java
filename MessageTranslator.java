package SoftUni.Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String regex = "!(?<command>[A-Z][a-z][a-z]+)!:\\[(?<message>[A-Za-z]{8,})\\]";

        int numOfMessages = Integer.parseInt(scanner.nextLine());

        Pattern msgPattern = Pattern.compile(regex);
        for (int i = 0; i < numOfMessages; i++) {
            String inputText = scanner.nextLine();
            Matcher matcher = msgPattern.matcher(inputText);

            if (matcher.find()) {
                String command = matcher.group("command");
                String msg = matcher.group("message");

                StringBuilder outPut = new StringBuilder();
                outPut.append(command).append(": ");
                encryptMessage(msg, outPut);

                System.out.println(outPut);

            } else {
                System.out.println("The message is invalid");
            }
        }
    }

    private static void encryptMessage(String msg, StringBuilder outPut) {
        for (int j = 0; j < msg.length(); j++) {
            int charValue = 0;
            charValue = msg.charAt(j);

            outPut.append(charValue).append(" ");
        }
    }
}
