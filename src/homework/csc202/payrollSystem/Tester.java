package homework.csc202.payrollSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 5/23/2017.
 * Created for Assignment 1 PayrollSystem
 * Created to test Employee, Manager, and HourlyWorker Classes
 */

public class Tester {
    public static void main(String[] args){


        File employee = new File("src/homework/CSC202/PayrollSystem", "employee.txt");

        try {
            Scanner reader = new Scanner(employee);

            while(reader.hasNextLine()) {
                StringBuilder read = new StringBuilder(reader.nextLine());
                if(read.subSequence(0,1).equals("#")){
                    read.replace(0,1,"");
                    String firstName = read.substring(0, read.indexOf(" "));
                    read.replace(0, read.indexOf(" "),"");

                    Manager manager = new Manager(firstName, read.toString());
                    manager.setWeeklySalary(Double.valueOf(reader.nextLine()));

                    System.out.println(manager.toString()+"\nEarned: "+manager.earnings()+"\n");
                }else if(read.subSequence(0,1).equals("*")){
                    read.replace(0,1,"");
                    String firstName = read.substring(0, read.indexOf(" "));
                    read.replace(0, read.indexOf(" "),"");

                    HourlyWorker worker = new HourlyWorker(firstName, read.toString());
                    worker.setWage(Double.valueOf(reader.nextLine()));
                    worker.setHours(Double.valueOf(reader.nextLine()));

                    System.out.println(worker.toString()+"\nEarned: "+worker.earnings()+"\n");
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }



    }
}
