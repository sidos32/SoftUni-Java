package SoftUni.Exams;

import java.util.Scanner;

public class StringManipulatorGroupTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");

            String action = tokens[0];

            switch (action) {
                case "Change":
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
                case"End":
                    String endString = tokens[1];

                    if (text.indexOf(endString) == text.length() - 1) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;

                case"FindIndex":
                    String indexOf = tokens[1];
                    int lastIndex = text.indexOf(indexOf);
                    System.out.println(lastIndex);

                    break;
                case"Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int lenght = Integer.parseInt(tokens[2]);

                    StringBuilder sb = new StringBuilder();

                    text = text.substring(startIndex,text.length());

                    for (int i = 0; i < lenght; i++) {
                        sb.append(text.charAt(i));
                    }

                    System.out.println(sb.toString());

                    break;

            }


            input = scanner.nextLine();

        }

    }

}
