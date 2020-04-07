package SoftUni.Exams;

import java.awt.event.MouseAdapter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        final String regex = "\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-Za-z]+)#";

        int numOfBosses = Integer.parseInt(scanner.nextLine());

        Pattern validBossPattern = Pattern.compile(regex);

        for (int i = 0; i < numOfBosses; i++) {
            String input = scanner.nextLine();

            Matcher bossMatcher = validBossPattern.matcher(input);
            if (bossMatcher.find()) {
                String bossName = bossMatcher.group("boss");
                String title = bossMatcher.group("title");

                int strength = bossName.length();
                int armour = title.length();

                System.out.printf("%s, The %s%n", bossName, title);
                System.out.printf(">> Strength: %d%n", strength);
                System.out.printf(">> Armour: %d%n", armour);
            } else {
                System.out.println("Access denied!");
            }

        }


    }
}
