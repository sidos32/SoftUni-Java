package SoftUni.OrderByAge;

public class Persons {


    public Persons(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    private String name;
    private String ID;
    private int age;

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", name, ID, age);
    }
}

