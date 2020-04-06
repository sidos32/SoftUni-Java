package SoftUni.FinalExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<Integer>> heroes = new TreeMap<>();

        int numOfHeroes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfHeroes; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            ArrayList<Integer> healthAndMana = new ArrayList<>();
            String heroName = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            healthAndMana.add(hp);//HP at index 0
            healthAndMana.add(mp);//MP at index 1

            heroes.put(heroName, healthAndMana);


        }
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String action = tokens[0];

            switch (action) {
                case "CastSpell":

                    String heroName = tokens[1];
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    if (heroes.get(heroName).get(1) >= mpNeeded) {
                        int oldMp = heroes.get(heroName).get(1); // MP at index 1
                        oldMp -= mpNeeded;
                        heroes.get(heroName).set(1, oldMp);

                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, oldMp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }

                    break;
                case "TakeDamage":
                    String heroDefenderName = tokens[1];
                    int damage = Integer.parseInt(tokens[2]);
                    String heroAttackerName = tokens[3];

                    int oldHP = heroes.get(heroDefenderName).get(0);//HP at index 0


                    if (oldHP - damage <= 0) {
                        System.out.printf("%s has been killed by %s!%n", heroDefenderName, heroAttackerName);
                        heroes.remove(heroDefenderName);
                    } else {
                        oldHP -= damage;
                        heroes.get(heroDefenderName).set(0, oldHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroDefenderName, damage, heroAttackerName, oldHP);
                    }


                    break;
                case "Recharge":

                    String heroToRecharge = tokens[1];
                    int manaAmount = Integer.parseInt(tokens[2]);

                    int oldMP = heroes.get(heroToRecharge).get(1);//MP at index 1


                    if (oldMP + manaAmount >= 200) {
                        System.out.printf("%s recharged for %d MP!%n", heroToRecharge, 200 - oldMP);
                        oldMP = 200;
                    } else {
                        oldMP += manaAmount;
                        System.out.printf("%s recharged for %d MP!%n", heroToRecharge, manaAmount);
                    }

                    heroes.get(heroToRecharge).set(1, oldMP);



                    break;
                case "Heal":

                    String heroToHeal = tokens[1];
                    int healAmount = Integer.parseInt(tokens[2]);

                    int health = heroes.get(heroToHeal).get(0);//Hp at index 0

                    if (health + healAmount > 100) {
                        System.out.printf("%s healed for %s HP!%n", heroToHeal, 100 - health);
                        health = 100;
                    } else {
                        health += healAmount;
                        System.out.printf("%s healed for %s HP!%n", heroToHeal, healAmount);
                    }
                    heroes.get(heroToHeal).set(0, health);

                    break;
            }

            input = scanner.nextLine();

        }

        heroes.entrySet()
                .stream()
                .sorted((h1, h2) -> h2.getValue().get(0) - h1.getValue().get(0))
                .forEach(e -> {
                    System.out.println(e.getKey());

                    int hp = e.getValue().get(0);
                    int mp = e.getValue().get(1);
                    System.out.println("  HP: " + hp);
                    System.out.println("  MP: " + mp);


                });

    }
}
