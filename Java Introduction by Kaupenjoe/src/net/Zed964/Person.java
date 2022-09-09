package net.Zed964;

public class Person {
    //Attributes
    private final String name;
    private int age;
    private final int socialNumber;

    Person(String name, int age, int socialNumber) {
        this.name = name;
        this.age = age;
        this.socialNumber = socialNumber;
    }

    public String getName() {
        return this.name;
    }
}
