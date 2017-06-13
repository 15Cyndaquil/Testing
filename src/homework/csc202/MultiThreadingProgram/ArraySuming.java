package homework.csc202.MultiThreadingProgram;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class ArraySuming implements Runnable {
    Thread thread;
    OneIntToPassThrough done;
    int[] summedArray;
    int[] arrayToSum;
    int row;

    public ArraySuming(int[] summedArray, int[] arrayToSum, int row, OneIntToPassThrough done){
        this.done = done;
        this.summedArray = summedArray;
        this.arrayToSum = arrayToSum;
        this.row = row;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        int output = 0;
        for(int i=0; i<arrayToSum.length; i++){
            output = output+arrayToSum[i];
        }
        summedArray[row] = output;
        done.add();
        System.out.println("Done: "+done.getInt());
    }

    public void start(){
        thread.start();
    }
}
