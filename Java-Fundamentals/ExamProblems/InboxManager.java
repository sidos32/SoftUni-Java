package SoftUni.Exams;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> userList = new TreeMap();

        String input = scanner.nextLine();

        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String user = tokens[1];

            switch (command) {
                case "Add":
                    if (userList.containsKey(user)) {
                        System.out.println(user + " is already registered");
                    } else {
                        userList.put(user, new ArrayList<>());
                    }
                    break;
                case "Send":
                    String message = tokens[2];
                    userList.get(user).add(message); //Check if user exist
                    break;
                case "Delete":
                    if (userList.containsKey(user)) {
                        userList.remove(user);
                    } else {
                        System.out.println(user + " not found!");
                    }
            }

            input = scanner.nextLine();
        }

        int size = userList.size();
        System.out.println("Users count: " + size);

        userList.entrySet()
                .stream()
                .sorted((u1, u2) -> u2.getValue().size() - u1.getValue().size())
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());
                    entry.getValue()
                            .forEach(v -> System.out.printf(" - %s%n", v));
                });


    }

    public static String printList(ArrayList<String> list) {

        return list.toString().replaceAll("[\\[\\]]", "");
    }
}
