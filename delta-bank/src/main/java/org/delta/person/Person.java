package org.delta.person;

public class Person {

    private String firstName;

    private String lastName;

    private String ID;

    public Person(String firstName, String lastName, String ID ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getID() {
        return ID;
    }
}
