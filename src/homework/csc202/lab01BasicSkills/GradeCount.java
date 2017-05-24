package homework.csc202.lab01BasicSkills;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 5/24/2017.
 */
public class GradeCount {
    public static void main(String[] args){
        File file = new File("src/homework/csc202/lab01BasicSkills","gradebook.txt");
        int a= 0;
        int b= 0;
        int c= 0;
        int d= 0;
        int f= 0;
        try{
            Scanner scanLine = new Scanner(file);

            while(scanLine.hasNextLine()){
                Scanner scanInt = new Scanner(scanLine.nextLine()).useDelimiter(" ");
                while(scanInt.hasNext()){
                    try {
                        int grade = Integer.valueOf(scanInt.next());
                        if (grade >= 90 && grade <= 100) {
                            a++;
                        } else if (grade >= 80 && grade <= 89) {
                            b++;
                        } else if (grade >= 70 && grade <= 79) {
                            c++;
                        } else if (grade >= 60 && grade <= 69) {
                            d++;
                        } else if (grade < 60) {
                            f++;
                        }
                    }catch (NumberFormatException e){
                    }
                }
            }
        }catch (FileNotFoundException e){

        }

        System.out.println("Category     No. of Students");
        System.out.println("[90 - 100]       "+a);
        System.out.println("[80 - 89]        "+b);
        System.out.println("[70 - 79]        "+c);
        System.out.println("[60 - 69]        "+d);
        System.out.println("[<60]            "+f);
    }
}
