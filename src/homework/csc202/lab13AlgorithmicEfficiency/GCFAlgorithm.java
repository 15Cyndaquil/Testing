package homework.csc202.lab13AlgorithmicEfficiency;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 15Cyndaquil on 7/4/2017.
 */
// Study the following code to understand how the gcf is calculated

public class GCFAlgorithm {

    public static int gcf1(int a, int b){
        if(Math.abs(a)==Math.abs(b)) return Math.abs(a);
        if(a*b==0) return Math.abs(a+b);
        return gcf1(a %b, b%a);
    }
    public static int gcf2(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);
        int tmp=a;
        if(a==b) return a;
        if(a * b==0) return a+b;
        while(a*b !=0){
            tmp=a;
            a =a %b;
            b = b % tmp;
        }
        return a+b;
    }
    public static int gcf3(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);
        int tmp=a;
        if(a==b) return a;
        if(a * b==0) return a+b;
        while(a*b !=0){
            if(a>b) a=a-b;
            else b=b-a;
        }
        return a+b;
    }
    public static void main(String[] args){
        //TO DO: add your codes here to evaluate the three gcf methods
        // use the system method: System.nanoTime()
        String output1, output2, output3;
        long fir1, fir2, fir3, sec1, sec2, sec3;
        int a, b, spaceAdd;
        File dir = new File("src/homework/csc202/lab13AlgorithmicEfficiency", "reader.txt");

        try{
            if(!dir.exists()){
                dir.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(dir);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("+-------+------------+------------+------------+\n");
            writer.write("| a, b  |    gcf1    |    gcf2    |    gcf3    |\n");
            writer.write("+-------+------------+------------+------------+\n");

            output(2, 6, writer);
            output(200, 1, writer);

            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private static void output(int a, int b, BufferedWriter writer) throws IOException{
        long fir1, fir2, fir3, sec1, sec2, sec3;
        String output1, output2, output3;
        fir1 = System.nanoTime();
        gcf1(a,b);
        sec1 = System.nanoTime();
        output1 = setOutput(String.valueOf(sec1 - fir1));

        fir2 = System.nanoTime();
        gcf2(a,b);
        sec2 = System.nanoTime();
        output2 = setOutput(String.valueOf(sec2 - fir2));

        fir3 = System.nanoTime();
        gcf3(a,b);
        sec3 = System.nanoTime();
        output3 = setOutput(String.valueOf(sec3 - fir3));

        switch (a){
            case 2:
                writer.write("| 2,  6 |"+output1+"|"+output2+"|"+output3+"|\n");
                break;
            case 200:
                writer.write("| 200,1 |"+output1+"|"+output2+"|"+output3+"|\n");
                break;
        }
    }
    private static String setOutput(String output){
        int spaceAdd = (12 - output.length());
        if(spaceAdd%2==0) {
            spaceAdd = spaceAdd/2;
            output = String.format("%" + spaceAdd + "s", " ") + output + String.format("%" + spaceAdd + "s", " ");
        }else {
            spaceAdd = spaceAdd/2;
            int spaceAdd1 = spaceAdd+1;
            output = String.format("%" + spaceAdd + "s", " ") + output + String.format("%" + spaceAdd1 + "s", " ");
        }
        return output;
    }
}