package SoftUni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {

    public static boolean isNameOnTheList(String name, List<String> list) {
        for (String it : list) {
            if (name.equals(it)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(sc.nextLine());
        List<String> listOfPeople = new ArrayList<String>();

        for (int i = 0; i < numOfCommands; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];

            if (tokens.length == 3) { //Is going to the party
                if (isNameOnTheList(name, listOfPeople)) {
                    System.out.printf("%s is already in the list! %n", name);
                } else {
                    listOfPeople.add(name);
                }

            } else {
                if (isNameOnTheList(name, listOfPeople)) { //Not going to the party
                    listOfPeople.remove(name);
                } else {
                    System.out.printf("%s is not in the list! %n", name);

                }
            }
        }


        for (String it : listOfPeople) {
            System.out.println(it);
        }


    }
}
