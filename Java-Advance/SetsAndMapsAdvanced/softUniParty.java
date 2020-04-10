package SoftUni.JavaAdvance.SetsAndMapsAdvanced;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class softUniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> guestsList = new TreeSet<>();

        while (!"PARTY".equals(input)){

            guestsList.add(input);

            input = scanner.nextLine();
        }



        while (!"END".equals(input)){

                guestsList.remove(input);

            input = scanner.nextLine();
        }


        System.out.println(guestsList.size());

        for (String guest:guestsList) {

            System.out.println(guest);

        }

    }
}
