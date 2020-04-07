package SoftUni.RegularExpressions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> furniture = new ArrayList<>();
        double finalPrice = 0.0;

        Pattern pattern = Pattern.compile(">>(?<furniture>\\w+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)");

        String input = scanner.nextLine();
        while (!"Purchase".equals(input)) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String item = matcher.group("furniture");
                double itemPrice = Double.parseDouble(matcher.group("price"));
                int itemQuantity = Integer.parseInt(matcher.group("quantity"));

                furniture.add(item);
                finalPrice += itemPrice * itemQuantity;

            }


            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f",finalPrice);
    }
}
