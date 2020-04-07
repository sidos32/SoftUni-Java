package SoftUni.FinalExam;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "TakeOdd":

                    StringBuilder oddChars = new StringBuilder();
                    for (int j = 0; j < text.length(); j++) {
                        if (j % 2 == 1) {
                            oddChars.append(text.charAt(j));
                        }
                    }
                    text = oddChars.toString();
                    System.out.println(text);

                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < index; i++) {
                        sb.append(text.charAt(i));
                    }

                    for (int i = index + length; i < text.length(); i++) {
                        sb.append(text.charAt(i));
                    }

                    text = sb.toString();

                    System.out.println(text);


                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if(text.contains(substring)){
                    text = text.replace(substring,substitute);
                        System.out.println(text);
                    }else {
                        System.out.println("Nothing to replace!");
                    }


                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Your password is: " + text);
    }
}