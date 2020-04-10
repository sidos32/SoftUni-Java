package SoftUni.JavaAdvance.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class parkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");

            String action = tokens[0];
            String carNumberPlate = tokens[1];

            if (action.equals("IN")) {
                parkingLot.add(carNumberPlate);
            } else {
                parkingLot.remove(carNumberPlate);
            }


            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (var car : parkingLot) {
                System.out.println(car);

            }
        }
    }
}
