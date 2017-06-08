package homework.csc202.MultiThreadingProgram;

import java.text.DecimalFormat;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class Driver {
    public static void main(String[] args){
        int[][] array = new int[20][20];
        int[] summedArray = new int[20];
        String[] done = new String[20];

        for(int row=0; row<array.length; row++){
            int[] arrayToSum = new int[20];
            for(int col=0; col<array.length; col++){
                int rand = (int)(Math.random()*100+1);
//                int rand = col;
                array[row][col] = rand;
                arrayToSum[row] = arrayToSum[row]+rand;
            }
            new ArraySuming(summedArray, arrayToSum, row, done).start();
        }

        for(int row=0; row<array.length; row++){
            for(int col=0; col<array.length; col++){
                System.out.print(String.format("%1$-3s",array[row][col])+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        boolean go = true;
        while(go){
            boolean toBreak = true;
            for(int i=0; i<done.length; i++){
                if(!done[i].equals("Done")){
                    toBreak=false;
                }
                if(toBreak){
                    go=false;
                }
            }
        }

        int index = -1;
        int max = 0;
        for(int i=0; i<summedArray.length; i++){
            System.out.println("Sum of row "+String.format("%1$-2s", i)+": "+String.format("%1$-4s",summedArray[i]));
            if(summedArray[i]>max){
                max = summedArray[i];
                index = i;
            }
        }
        System.out.println("\nIndex with highest sum: "+index);
    }
}
