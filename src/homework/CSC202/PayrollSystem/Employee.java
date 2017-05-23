package homework.CSC202.PayrollSystem;

/**
 * Created by 15Cyndaquil on 5/23/2017.
 * Created for Assignment 1 PayrollSystem
 */

abstract class Employee {
    private String firstName, lastName;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String toString(){
        return firstName+" "+lastName;
    }


    abstract public double earnings();
}
