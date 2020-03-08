package SoftUni.Maps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Double>> students = new LinkedHashMap<>();

        int numOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfStudents; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.entrySet()
                .stream()
                .filter(student -> student.getValue()
                        .stream()
                        .mapToDouble(Double::valueOf)
                        .average()
                        .getAsDouble() >= 4.50)
                .sorted((student1, student2) -> {
                    double first = student1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = student2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();

                    return Double.compare(second, first);
                })
                .forEach(student -> System.out.println(String.format
                        ("%s -> %.2f", student.getKey(), student.getValue()
                                                        .stream()
                                                        .mapToDouble(Double::doubleValue)
                                                        .average()
                                                        .getAsDouble())));


    }
}
