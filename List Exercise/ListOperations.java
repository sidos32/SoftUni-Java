package SoftUni;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        boolean isEndOfProgram = false;

        while (!isEndOfProgram) {
            String[] command = sc.nextLine().split("\\s+");

            if (command[0].equals("End")) {
                isEndOfProgram = true;

            } else if (command[0].equals("Add")) {
                int num = Integer.parseInt(command[1]);
                numbers.add(num);

            } else if (command[0].equals("Remove")) {
                int index = Integer.parseInt(command[1]);

                if (index >= numbers.size() || index < 0) {
                    System.out.println("Invalid index");
                } else {

                    numbers.remove(index);
                }

            } else if (command[0].equals("Insert")) {
                int element = Integer.parseInt(command[1]);
                int index = Integer.parseInt(command[2]);


                if (index >= numbers.size()|| index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index, element);
                }


            } else if (command[0].equals("Shift")) {

                if (command[1].equals("right")) {
                    int n = Integer.parseInt(command[2]);
                    Collections.rotate(numbers, n);

                } else if (command[1].equals("left")) {
                    int n = Integer.parseInt(command[2]);
                    for (int i = 0; i < n; i++) {
                        int temp = numbers.get(0);
                        for (int j = 0; j < numbers.size() - 1; j++) {
                            numbers.set(j, numbers.get(j + 1));
                        }
                        numbers.set(numbers.size() - 1, temp);
                    }
                }
            }
        }

        for (int it : numbers) {
            System.out.print(it + " ");
        }


    }
}
