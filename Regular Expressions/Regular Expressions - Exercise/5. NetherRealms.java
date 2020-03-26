package SoftUni.RegularExpressions;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demons = scanner.nextLine().split(",\\s+");

        TreeMap<String, Integer> demonHealth = new TreeMap<>();
        TreeMap<String, Double> demonDamage = new TreeMap<>();

        String regexDemonNameAndHealth = "[A-Za-z]";
        String regexDemonDamage = "[+-]*[0-9]+\\.?[0-9]?";


        for (int i = 0; i < demons.length; i++) {
            int hp = 0;
            double damage = 0;
            String demonName = demons[i].replaceAll(" ", "");

            Pattern nameAndHealthPatter = Pattern.compile(regexDemonNameAndHealth);
            Matcher nameAndHealthMAtcher = nameAndHealthPatter.matcher(demonName);

            Pattern damagePattern = Pattern.compile(regexDemonDamage);
            Matcher damageMatcher = damagePattern.matcher(demonName);

            Pattern multiplyOrDavide = Pattern.compile("[*\\/]");
            Matcher mMatcher = multiplyOrDavide.matcher(demonName);

            while (nameAndHealthMAtcher.find()) {
                char ch = nameAndHealthMAtcher.group().charAt(0);
                hp += ch;
            }

            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            while (mMatcher.find()) {
                if (mMatcher.group().equals("*")) {
                    damage = damage * 2;
                } else if (mMatcher.group().equals("/")) {
                    damage = damage / 2;
                }
            }

            demonHealth.put(demonName.toString(), hp);
            demonDamage.put(demonName.toString(), damage);
        }
        for (var it : demonHealth.entrySet()) {
            System.out.printf("%s - %d health, %.2f damage%n", it.getKey(), it.getValue(), demonDamage.get(it.getKey()));

        }
    }
}
