package SoftUni.Maps;


import java.util.LinkedHashMap;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Double> orders = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsQuantity = new LinkedHashMap<>();


        String[] tokens = sc.nextLine().split("\\s+");

        while (!"buy".equals(tokens[0])) {
            String type = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);


            if(orders.containsKey(type)){

                    productsQuantity.put(type,productsQuantity.get(type) + quantity );
                    orders.put(type,productsQuantity.get(type) * price);

            }else {

                orders.putIfAbsent(type,price * quantity);
                productsQuantity.putIfAbsent(type,quantity);
            }


            tokens = sc.nextLine().split("\\s+");
     }


        for (var entry:orders.entrySet()) {
            System.out.printf("%s -> %.2f\n",entry.getKey(),entry.getValue());
        }

    }
}
