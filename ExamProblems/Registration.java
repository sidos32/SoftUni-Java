package SoftUni.Exams;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regustration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String emailRegex =
                "^[U$]+(?<name>[A-Z][a-z][a-z]+)[U$]+[\"P@$\"]+(?<password>[A-Za-z]{5,}\\d+)[\"P@$\"]+";

        Pattern emailPattern = Pattern.compile(emailRegex);

        int numOfUsers = Integer.parseInt(scanner.nextLine());
        int successfulRegs = 0;
        for (int i = 0; i < numOfUsers; i++) {
            String input = scanner.nextLine();
            Matcher matcher = emailPattern.matcher(input);

            if(matcher.find()){
                String userName = matcher.group("name");
                String password = matcher.group("password");

                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n",userName,password);
                successfulRegs++;
            }else {
                System.out.println("Invalid username or password");
            }
        }

        System.out.printf("Successful registrations: %d",successfulRegs);
    }
}
