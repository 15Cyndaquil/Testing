package homework.bookProblems.ch1.prob_7;

/**
 * Created by Cyndaquil on 6/10/2017.
 */
public class PIThread implements Runnable {
    Thread thread;
    private Double currentOdd;
    private double[] array;
    private int index;

    public PIThread(Double currentOdd, int index, double[] array){
        this.currentOdd = currentOdd;
        this.index = index;
        this.array = array;
        thread = new Thread(this);
    }
    @Override
    public void run() {
        array[index] = (1d/currentOdd);
    }

    public void start(){
        thread.start();
    }
}
