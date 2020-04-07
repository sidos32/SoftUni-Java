package SoftUni.Exams;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Nikuldensmeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> costumers = new TreeMap<>();

        String input = scanner.nextLine();

        int unlikedMealCounter = 0;
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String name = tokens[1];
            String meal = tokens[2];

            if (command.equals("Like")) {
                ArrayList<String> listOfMeals = costumers.get(name);

                if(listOfMeals == null){
                    listOfMeals = new ArrayList<>();
                }

                if (!listOfMeals.contains(meal)) {
                    listOfMeals.add(meal);
                }

                costumers.put(name,listOfMeals);

            } else {
                if (!costumers.containsKey(name)) {
                    System.out.println(name + "is not at the party.");
                }else {
                    ArrayList<String> listOfMeals = costumers.get(name);
                    if(listOfMeals.contains(meal)){
                        listOfMeals.remove(meal);
                        costumers.put(name,listOfMeals);
                        System.out.printf("%s doesn't like the %s.%n",name,meal);
                        unlikedMealCounter++;
                    }else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n",name,meal);

                    }
                }
            }
            input = scanner.nextLine();
        }

        costumers.entrySet()
                .stream()
                .sorted((r,l)->{
                    int compare = r.getValue().size() - l.getValue().size();
                    return compare == 0 ? r.getKey().compareTo(l.getKey()) : compare;
                }).sorted((l,r)->l.getValue().size() - r.getValue().size())
                .forEach(e-> System.out.println(e.getKey() + ": " + printList(e.getValue())));

        System.out.println("Unliked meals: " + unlikedMealCounter);
    }

    public static String printList (ArrayList<String> meals){

       return meals.toString().replaceAll("[\\[\\]]","");
    }

}
