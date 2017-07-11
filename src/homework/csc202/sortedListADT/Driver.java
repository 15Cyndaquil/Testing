package homework.csc202.sortedListADT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Cyndaquil on 6/26/2017.
 */
public class Driver {
    private static ArrayListSorted tester = new ArrayListSorted();

    public static void main(String[] args){
        Course test = new Course("CSC", Short.valueOf(String.valueOf(202)), "Computre Science I", "Professor Davis");


        File file = new File("src/homework/csc202/sortedListADT", "data.txt");
        readFile(file);

        tester.add(test);
        ArrayListSorted copy1 = tester.copy();
        ArrayListSorted copy2 = tester.copy(1,4);
        copy1.println();
        copy2.println();
        System.out.println(tester.contains(test));
        System.out.println(tester.get(1).getValue());
        tester.println();
        tester.remove(1);
        System.out.println(tester.get(1).getValue());
        tester.remove(test);
        tester.println();
        tester.clear();
        tester.println();


    }

    private static void readFile(File file){
        try{
            Scanner read = new Scanner(file).useDelimiter(" ");
            while(read.hasNext()){
                String line0 = read.nextLine();
                String line1 = read.nextLine();
                String line2 = read.nextLine();

                tester.add(new Course(line0.substring(0, line0.indexOf(" ")), Short.valueOf(line0.substring(line0.indexOf(" ")).trim()), line1, line2));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
