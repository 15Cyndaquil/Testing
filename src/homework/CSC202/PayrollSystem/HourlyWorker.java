package homework.CSC202.PayrollSystem;

/**
 * Created by 15Cyndaquil on 5/23/2017.
 * Created for Assignment 1 PayrollSystem
 */

public class HourlyWorker extends Employee {
    private double wage, hours;

    public HourlyWorker(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public double getWage() {
        return wage;
    }
    public double getHours() {
        return hours;
    }


    public void setWage(double wage) {
        if(wage>=25&&wage<=50) {
            this.wage = wage;
        }else {
            this.wage = 35;
        }
    }
    public void setHours(double hours) {
        if(hours>60){
            this.hours = 60;
        }else {
            this.hours = hours;
        }
    }


    @Override
    public double earnings() {
        if(hours>40){
            return (wage*40)+((wage*1.5)*(hours-40));
        }else {
            return wage*hours;
        }
    }

    @Override
    public String toString(){
        return "Hourly Worker: "+getFirstName()+" "+getLastName();
    }
}
