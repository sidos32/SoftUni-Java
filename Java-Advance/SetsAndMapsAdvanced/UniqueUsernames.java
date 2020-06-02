package SoftUni.JavaAdvance.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String>users = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            users.add(scanner.nextLine());
        }

        for (var name:users) {
            System.out.println(name);
        }
    }
}
