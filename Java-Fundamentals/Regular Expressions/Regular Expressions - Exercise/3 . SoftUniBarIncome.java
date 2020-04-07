package SoftUni.RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern costumerPattern = Pattern.compile("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<" +
                "(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$");

        String input = scanner.nextLine();

        double totalIncome = 0;
        while (!"end of shift".equals(input)) {

            Matcher validCostumerMatcher = costumerPattern.matcher(input);

            while (validCostumerMatcher.find()) {

                String nameOfCostumer = validCostumerMatcher.group("name");
                String itemBought = validCostumerMatcher.group("product");
                double price = Double.parseDouble(validCostumerMatcher.group("price"));
                int quantity = Integer.parseInt(validCostumerMatcher.group("count"));

                System.out.printf("%s: %s - %.2f%n", nameOfCostumer, itemBought, price * quantity);
                totalIncome += price * quantity;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}