package SoftUni.Exams;

import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Replace":
                    String oldChar = tokens[1];
                    String newChar = tokens[2];
                    text = text.replace(oldChar, newChar);
                    System.out.println(text);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    text = cut(text, startIndex, endIndex);
                    break;

                case "Make":
                    String upperOrLower = tokens[1];
                    if (upperOrLower.equals("Upper")) {
                        text = text.toUpperCase();
                    } else {
                        text = text.toLowerCase();
                    }
                    System.out.println(text);
                    break;

                case "Check":
                    String check = tokens[1];

                    if (text.contains(check)) {
                        System.out.println("Message contains " + check);
                    } else {
                        System.out.println("Message doesn't contain " + check);
                    }
                    break;

                case "Sum":
                    int startIndexSum = Integer.parseInt(tokens[1]);
                    int endIndexSum = Integer.parseInt(tokens[2]);

                    sum(text, startIndexSum, endIndexSum);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isValidIndex(int toCheck, int size) {
        return toCheck >= 0 && toCheck < size;
    }

    private static String cut(String text, int startIndex, int endIndex) {
        int length = text.length();

        if (!isValidIndex(startIndex, length)) {
            System.out.println("Invalid indexes!");
            return text;
        } else if (!isValidIndex(endIndex, length)) {
            System.out.println("Invalid indexes!");
            return text;
        }
        String firstPart = text.substring(0, startIndex);
        String secondPart = text.substring(endIndex + 1, length);

        System.out.println(firstPart + secondPart);
        return firstPart + secondPart;

    }

    private static void sum(String text, int startIndex, int endIndex) {
        int length = text.length();
        if (asd(startIndex, endIndex, length)) return;

        int sum = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            sum += text.charAt(i);
        }

        System.out.println(sum);
    }

    private static boolean asd(int startIndex, int endIndex, int length) {
        if (!isValidIndex(startIndex, length)) {
            System.out.println("Invalid indexes!");
            return true;

        } else if ((!isValidIndex(endIndex, length))) {
            System.out.println("Invalid indexes!");
            return true;
        }
        return false;
    }


}

