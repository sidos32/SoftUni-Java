package SoftUni.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String regex = "@+#+([A-Z][A-Za-z0-9]{4,}[A-Z])@+#+";
        int numOfProducts = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < numOfProducts; i++) {
            String inputText = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputText);

            if(matcher.find()){
                String barCode= matcher.group(1);
                Pattern digitPattern = Pattern.compile("\\d");
                Matcher digitMatcher = digitPattern.matcher(barCode);

                StringBuilder sb = new StringBuilder();
                while (digitMatcher.find()){
                    sb.append(digitMatcher.group());

                }

                String print = sb.toString();
                if(print.isEmpty()){
                    System.out.println("Product group: 00");
                }
                else {
                    System.out.printf("Product group: %s%n",print);
                }

            }else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
