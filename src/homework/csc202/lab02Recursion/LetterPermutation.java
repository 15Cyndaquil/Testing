package homework.csc202.lab02Recursion;

import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 5/25/2017.
 */
public class LetterPermutation {
    public static void main(String[] args){
//        int input;
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter an int: ");
//        input = scan.nextInt();
//        scan.close();
//        System.out.println(letterTimes(input, (int) Math.pow(2, input)));
        permutatioon(3,"");
        System.out.println("\n");
        permutatioon(4,"");
    }

    public static String letterTimes(int input, int powered){
        StringBuilder output = new StringBuilder("");
        if (powered == 0) {
            return output.toString();
        }else {
            output.append(String.valueOf(Integer.toBinaryString(powered)));
            while (output.length() < input) {
                String currentOutput = output.toString();
                output.replace(0, output.length(), "0" + currentOutput);
            }
            output.replace(0, output.length() - input, "");
            for (int x = 0; x < input; x++) {
                if (output.indexOf("0") != -1) {
                    output.replace(output.indexOf("0"), output.indexOf("0") + 1, "L");
                } else if (output.indexOf("1") != -1) {
                    output.replace(output.indexOf("1"), output.indexOf("1") + 1, "R");
                }
            }
            output.append("\n" + letterTimes(input, powered-1));
            return output.toString();
        }
    }

    public static void permutatioon(int len, String str){
        if(len==1){
            System.out.println(str+"L");
            System.out.println(str+"R");
        }else{
            permutatioon(len-1,str+"L");
            permutatioon(len-1,str+"R");
        }
    }
}
