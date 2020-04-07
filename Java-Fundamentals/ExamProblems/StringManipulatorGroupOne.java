package SoftUni.Exams;

import java.util.Scanner;

public class StringManipulatorGroupOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String action = tokens[0];

            switch (action) {

                case "Translate":

                    String charToReplace = tokens[1];
                    String replacement = tokens[2];

                    text = text.replace(charToReplace, replacement);
                    System.out.println(text);

                    break;
                case "Includes":

                    String containString = tokens[1];

                    if (text.contains(containString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;
                case "Start":

                    String startString = tokens[1];

                    if (text.indexOf(startString) == 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;
                case "Lowercase":

                    text = text.toLowerCase();
                    System.out.println(text);

                    break;
                case "FindIndex":

                    String indexOf = tokens[1];
                    int lastIndex = text.lastIndexOf(indexOf);
                    System.out.println(lastIndex);

                    break;
                case "Remove":

                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);

                        StringBuilder sb = new StringBuilder();
                        sb.append(text);
                    sb.replace(startIndex, startIndex + count, "");
                       text = sb.toString();
                        System.out.println(text);


                    break;
            }


            input = scanner.nextLine();

        }

    }
}
