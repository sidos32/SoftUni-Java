package SoftUni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        boolean isEndOfProgram = false;

        while (!isEndOfProgram) {
            String[] command = sc.nextLine().split("\\s+");

            if (command[0].equals("end")) {
                isEndOfProgram = true;

            } else if (command[0].equals("Delete")) {
                int num = Integer.parseInt(command[1]);
                numList.removeAll(Arrays.asList(num));

            } else if (command[0].equals("Insert")) {
                int element = Integer.parseInt(command[1]);
                int position = Integer.parseInt(command[2]);

                if (position < numList.size()){
                    numList.add(position, element);
                }


            }
        }


        for (int it : numList) {
            System.out.print(it + " ");
        }

    }
}