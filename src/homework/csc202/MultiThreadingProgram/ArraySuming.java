package homework.csc202.MultiThreadingProgram;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class ArraySuming implements Runnable {
    Thread thread;
    String[] done;
    int[] summedArray;
    int[] arrayToSum;
    int row;

    public ArraySuming(int[] summedArray, int[] arrayToSum, int row, String[] done){
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
        done[row]= "Done";
    }

    public void start(){
        thread.start();
    }
}
