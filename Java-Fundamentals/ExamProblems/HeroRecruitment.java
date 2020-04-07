package SoftUni.Exams;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> heroesList = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String hero = tokens[1]; //Maybe in this line is a bug ?

            switch (command) {
                case "Enroll":

                    if (heroesList.containsKey(hero)) {
                        System.out.println(hero + " is already enrolled.");
                    } else {
                        heroesList.put(hero, new ArrayList<>());
                    }
                    break;

                case "Learn":
                    String spell = tokens[2];
                    if (heroesList.containsKey(hero)) {
                        if (heroesList.get(hero).contains(spell)) {
                            System.out.printf("%s has already learnt %s.%n", hero, spell);
                        } else {
                            heroesList.get(hero).add(spell);
                        }
                    } else {
                        System.out.println(hero + " doesn't exist.");
                    }

                    break;
                case "Unlearn":
                    spell = tokens[2];
                    if (heroesList.containsKey(hero)) {

                        if (heroesList.get(hero).contains(spell)) {
                            heroesList.get(hero).remove(spell);
                        } else {
                            System.out.printf("%s doesn't know %s.%n", hero, spell);
                        }
                    } else {
                        System.out.println(hero + " doesn't exist.");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroesList.forEach((key, value) -> System.out.println("== " + key + ": " + printList(value)));


    }

    public static String printList(ArrayList<String> list) {

        return list.toString().replaceAll("[\\[\\]]", "");
    }
}
