package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        testCont();
    }

    private static void testCont(){

    }




        private static void testFiles(){
        File dir0 = new File("src/main/java/test/create");
        File file0 = new File(dir0, "text0.txt");
        File file1 = new File(dir0, "text1.txt");
        File file2 = new File(dir0, "text2.txt");

        dir0.mkdir();

        try {
            PrintWriter writer0 = new PrintWriter(file0);
            PrintWriter writer1 = new PrintWriter(file1);
            PrintWriter writer2 = new PrintWriter(file2);

            writer0.close();
            writer1.close();
            writer2.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for(int i=0; i<dir0.listFiles().length; i++){
            System.out.println(dir0.listFiles()[i]);
        }
    }



    private static double divide(int n1, int n2) throws ArithmeticException{
//        return (double) n1/(double) n2;
        return n1/n2;
    }
    private static void testExceptions(){
        try {
            System.out.println(divide(10, 0));
            System.out.println(divide(20,5));
        }catch (ArithmeticException exc){
            System.out.println(exc.getStackTrace()[0]);
            System.out.println(exc.getMessage());
        }
    }



}
