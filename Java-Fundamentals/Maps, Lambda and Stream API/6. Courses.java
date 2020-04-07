package SoftUni.Maps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,ArrayList<String>> courses =  new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!"end".equals(command)){
            String[] tokens = command.split(" : ");
            String courseName = tokens[0];
            String name = tokens[1];

            if (!courses.containsKey(courseName)) {
                courses.putIfAbsent(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(name);


            command = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((f,s)->s.getValue().size() - f.getValue().size())
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(e -> System.out.printf("--%s%n", e));
        });


    }
}
