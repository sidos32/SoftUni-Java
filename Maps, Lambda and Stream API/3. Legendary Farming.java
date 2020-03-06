package SoftUni.Maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> inventory = new TreeMap<>() {{
            put("fragments", 0);
            put("shards", 0);
            put("motes", 0);
        }};
        TreeMap<String, Integer> junkInventory = new TreeMap<>();

        boolean isItemOptained = false;

        while (!isItemOptained) {
            String[] tokens = sc.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {

                int quantity = Integer.parseInt(tokens[i]);
                String item = tokens[i + 1].toLowerCase();

                if (inventory.containsKey(item)) {
                    addItems(inventory, item, quantity);
                    isItemOptained = isLegendaryOptainable(inventory,item);
                    if(isItemOptained){
                        break;
                    }
                } else {
                    addItems(junkInventory, item, quantity);
                }
            }
        }

        inventory.entrySet()
                 .stream()
                 .sorted((i1,i2) -> Integer.compare(i2.getValue(),i1.getValue()))
                 .forEach(i -> System.out.println(String.format("%s: %d", i.getKey(), i.getValue())));

        junkInventory.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));
    }


    public static boolean isLegendaryOptainable(Map<String,Integer> mapItems,String item){
        int count = mapItems.get(item);

        if(count >= 250){
            mapItems.put(item,count - 250);
            switch (item){
                case"shards":
                    System.out.println("Shadowmourne obtained!");
                    return true;
                case"fragments":
                    System.out.println("Valanyr obtained!");
                    return true;
                case"motes":
                    System.out.println("Dragonwrath obtained!");
                    return true;
            }
        }
        return false;
    }

    public static void addItems(Map<String, Integer> mapItems, String item, int quantity) {
        mapItems.putIfAbsent(item, 0);
        int count = mapItems.get(item);

        mapItems.put(item, count + quantity);

    }
}
