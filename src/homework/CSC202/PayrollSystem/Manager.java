package homework.CSC202.PayrollSystem;

/**
 * Created by 15Cyndaquil on 5/23/2017.
 * Created for Assignment 1 PayrollSystem
 */

public class Manager extends Employee {
    private double weeklySalary;

    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
    }


    public double getWeeklySalary() {
        return weeklySalary;
    }


    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }



    @Override
    public double earnings() {
        if(weeklySalary>=800&&weeklySalary<=2000){
            return weeklySalary;
        }else {
            return 0;
        }
    }


    @Override
    public String toString(){
        return "Manage: "+getFirstName()+" "+getLastName();
    }
}
