package SoftUni.TextProcessing;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] users = scanner.nextLine().split(", ");


        for (String username : users) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);

            if (!Character.isLetterOrDigit(ch) && ch != '_' && ch != '-') {
                return false;
            }
        }
        return true;
    }
}
