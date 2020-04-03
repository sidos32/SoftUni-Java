package SoftUni.Exams;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<Integer>> warriorList = new TreeMap<>();


        String input = scanner.nextLine();

        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    String warriorName = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);


                    if (warriorList.containsKey(warriorName)) {
                        int oldHealth = warriorList.get(warriorName).get(0); //Get health from index 0
                        warriorList.get(warriorName).set(0, oldHealth + health); //Set at index 0 new health
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(health);
                        list.add(energy);
                        warriorList.put(warriorName, list);
                    }

                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (warriorList.containsKey(attackerName) && warriorList.containsKey(defenderName)) {
                        int oldHealth = warriorList.get(defenderName).get(0); //Get health from index 0
                        oldHealth -= damage; //Reducing health

                        if(oldHealth <= 0){ //If health reaches 0 or below warrior dies
                            System.out.println( defenderName + " was disqualified!");
                            warriorList.remove(defenderName);
                        }else {
                            warriorList.get(defenderName).set(0,oldHealth);
                        }

                        int oldEnergy = warriorList.get(attackerName).get(1);

                        --oldEnergy;
                        if (oldEnergy <= 0){
                            System.out.println(attackerName + " was disqualified!");
                            warriorList.remove(attackerName);
                        }else {
                            warriorList.get(attackerName).set(1,oldEnergy);
                        }

                    }

                    break;
                case "Delete":
                    warriorName = tokens[1];
                    if (warriorName.equals("All")) { //Deletes all of warriors
                        warriorList = new TreeMap<>();
                    }

                    warriorList.remove(warriorName); //Deletes if warrior exist;

                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("People count: " + warriorList.size());

        warriorList.entrySet()
                .stream()
                .sorted((w1,w2)-> w2.getValue().get(0) - w1.getValue().get(0)) //Sorting by health
                .forEach(e ->{
                    System.out.printf("%s - %d - %d%n",e.getKey(),e.getValue().get(0),e.getValue().get(1));
                });


        }



    }

