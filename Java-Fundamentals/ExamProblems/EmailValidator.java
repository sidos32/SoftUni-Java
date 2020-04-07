package SoftUni.Exams;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String input = scanner.nextLine();

        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "GetDomain":
                    int lastThreeChars = Integer.parseInt(tokens[1]);
                    getDomain(email, lastThreeChars);
                    break;

                case "Make": {

                    if (tokens[1].equals("Upper")) {
                        email = email.toUpperCase();

                    } else {
                        email = email.toLowerCase();
                    }
                    System.out.println(email);
                    break;

                }
                case "GetUsername":
                    getUser(email);
                    break;

                case "Encrypt":
                    encryptEmail(email);
                    break;

                case "Replace":
                    String charToReplace = tokens[1];
                    email = email.replace(charToReplace,"-");
                    System.out.println(email);
            }



            input = scanner.nextLine();
        }

    }

    private static void getDomain(String email, int domainCharCount) {
        String domain = email.substring(email.length() - domainCharCount, email.length());
        System.out.println(domain);
    }

    private static void getUser(String text) {
        if (text.contains("@")) {
            int index = text.indexOf("@");
            String printUser = text.substring(0, index);
            System.out.println(printUser);
        } else {
            System.out.printf("The email %s doesn't contain the @ symbol.%n", text);
        }
    }

    private static void encryptEmail(String email) {
        StringBuilder outPut = new StringBuilder();
        for (int j = 0; j < email.length(); j++) {
            int charValue = 0;
            charValue = email.charAt(j);

            outPut.append(charValue).append(" ");
        }
        System.out.println(outPut);
    }

}

