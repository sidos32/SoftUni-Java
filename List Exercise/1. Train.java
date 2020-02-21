package SoftUni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> train = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int wagonCapacity = Integer.parseInt(sc.nextLine());

        boolean isEndOfProgram = false;

        while (!isEndOfProgram) {
            String[] command = sc.nextLine().split(" ");


            if (command[0].equals("Add")) {
                train.add(Integer.valueOf(command[1]));
            } else if (command[0].equals("end")) {
                isEndOfProgram = true;
            } else {
                int peoples = Integer.parseInt(command[0]);

                for (int i = 0; i < train.size(); i++) {
                    //Checks if the people are less than wagon capacity
                    if (peoples + train.get(i) <= wagonCapacity) {
                        train.set(i, peoples + train.get(i));
                        break;
                    }
                }
            }
        }


        for (int it : train) {
            System.out.print(it + " ");
        }

    }
}
