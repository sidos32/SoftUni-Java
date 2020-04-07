package SoftUni.OpinionPoll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Persons> listOfPersons = new ArrayList<>();

        int numOfPeople = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numOfPeople; i++) {

            String[] tokens = sc.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Persons person = new Persons(name, age);

            listOfPersons.add(person);

        }

        listOfPersons.stream()
                .filter(p -> p.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.println(p.toString()));


    }
}
