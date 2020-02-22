package SoftUni.Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(sc.nextLine());

        ArrayList<Students> studentsList = new ArrayList<Students>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);

            Students student = new Students(firstName,secondName,grade);

            studentsList.add(student);
        }

        //Sorting by descending order
        studentsList.sort(new Comparator<Students>() {
            @Override
            public int compare(Students s1, Students s2) {
                return Double.compare(s2.getGrade(), s1.getGrade());
            }
        });


        for (Students it:studentsList) {
            System.out.println(it.toString());
        }
    }
}
