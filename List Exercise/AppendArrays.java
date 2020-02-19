package SoftUni;

import java.util.*;

public class AppendArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\|");

        List<String> result = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            String[] arr = input[i].trim().split("\\s+");

            result.addAll(Arrays.asList(arr));
            result.remove("");
        }

        System.out.println(String.join(" ", result));

    }
}
