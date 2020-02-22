package SoftUni.Students;

public class Students {
    String firstName;

    String secondName;
    double grade;
    public Students(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
       return String.format("%s %s: %.2f",firstName,secondName,grade);
    }


}


