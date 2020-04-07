package SoftUni.OrderByAge;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Persons> peoples = new ArrayList<Persons>();

        boolean isEndOfProgram = false;

        while (!isEndOfProgram) {
            String[] tokens = sc.nextLine().split(" ");
                int i = tokens.length;

            if (tokens[0].equals("End")) {
                isEndOfProgram = true;
            }else{

                String name = tokens[0];
                String ID = tokens[1];
                int age = Integer.parseInt(tokens[2]);

                Persons person = new Persons(name, ID, age);

                peoples.add(person);
            }
        }

<<<<<<< HEAD
        peoples.sort((p2, p1) -> p2.getAge() + p1.getAge());
=======
        Collections.sort(peoples, (p1, p2) -> p1.getAge() - p2.getAge());
>>>>>>> af325a71b84c845f8db8a7a4d1bdd4b8545c071b

        for (Persons it:peoples) {
            System.out.println(it.toString());
        }

    }

}


