package SoftUni;

import java.util.*;

public class TreasureHunt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> chest = new ArrayList<>(Arrays.asList(sc.nextLine().split("\\|")));

        boolean endOfTreasureHunt = false;


        while (!endOfTreasureHunt) {

            String[] tokens = sc.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        String item = tokens[i];

                        if (isNoItemFound(chest, item)) {
                            chest.add(0, item);
                        }
                    }
                    break;

                case "Drop":

                    int index = Integer.parseInt(tokens[1]);
                    if (isIndexValid(index,chest)) {
                        String item = chest.get(index);

                        chest.remove(index);
                        chest.add(item);
                    }
                    break;

                case "Steal":
                    int numOfStolenItems = Integer.parseInt(tokens[1]);

                    if (isIndexValid(numOfStolenItems,chest)) {
                        System.out.println(String.join(", ", chest));
                        chest.clear();
                        break;
                    }

                    ArrayList<String> stolenItems = new ArrayList<>();
                        for (int i = 0; i < numOfStolenItems; i++) {
                            int lastIndex = chest.size() - 1;
                            String element = chest.get(lastIndex);
                            chest.remove(lastIndex);
                            stolenItems.add(element);

                        }
                        Collections.reverse(stolenItems);
                        System.out.println(String.join(", ", stolenItems));

                    break;
            }


            if (tokens[0].equals("Yohoho!")) {
                endOfTreasureHunt = true;
            }
        }


        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double totalSumOfItems = 0;
            for (String it : chest) {
                totalSumOfItems += it.length();
            }

            totalSumOfItems = totalSumOfItems / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",totalSumOfItems);
        }


    }


    public static boolean isNoItemFound(ArrayList<String> chest, String item) {

        for (String it : chest) {
            if (it.equals(item)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIndexValid(int index, List<String> treasure) {
        return index >= 0 && index < treasure.size();
    }


}
