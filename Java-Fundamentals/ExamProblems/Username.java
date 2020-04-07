package SoftUni.Exams;

import javax.print.DocFlavor;
import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();


        String input = scanner.nextLine();

        while (!"Sign up".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];


            switch (command) {
                case "Case":

                    if ("upper".equals(tokens[1])) {
                        text = text.toUpperCase();
                    } else if ("lower".equals(tokens[1])) {
                        text = text.toLowerCase();
                    }
                    System.out.println(text); // May cause bug

                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex < text.length()) {// May cause bug
                        StringBuilder subString = new StringBuilder();
                        subString.append(text.substring(startIndex, endIndex + 1));// May cause bug
                        System.out.println(subString.reverse());
                    }

                    break;
                case "Cut":
                    String subString = tokens[1];
                    if (text.contains(subString)) {
                        text = text.replace(subString, "");
                        System.out.println(text);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", text, subString);
                    }

                    break;
                case "Replace":
                    String replaceChar = tokens[1];
                    text = text.replace(replaceChar, "*");
                    System.out.println(text);

                    break;
                case "Check":
                    String check = tokens[1];
                    if(text.contains(check)){
                        System.out.println("Valid");
                    }else {
                        System.out.printf("Your username must contain %s.%n",check);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
