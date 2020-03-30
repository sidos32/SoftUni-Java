package SoftUni.Exams;

import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"For Azeroth".equals(input)) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "GladiatorStance":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;

                case "DefensiveStance":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;

                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];

                    if (index >= 0 && index < text.length()) {
                        String start = text.substring(0, index) + letter;
                        String finish = text.substring(index + 1, text.length());
                        text = start + finish;
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;

                case "Target":

                    if ("Change".equals(tokens[1])) {
                        String stringToReplace = tokens[2];
                        String replacingString = tokens[3];
                        text = text.replace(stringToReplace, replacingString);
                        System.out.println(text);

                    } else if ("Remove".equals(tokens[1])) {
                        String removeSubString = tokens[2];
                        text = text.replace(removeSubString, "");
                        System.out.println(text);
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;

                default:
                    System.out.println("Command doesn't exist!");
            }


            input = scanner.nextLine();
        }
    }
}
