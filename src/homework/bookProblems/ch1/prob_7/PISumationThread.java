package homework.bookProblems.ch1.prob_7;

/**
 * Created by Cyndaquil on 6/10/2017.
 */
public class PISumationThread implements Runnable {
    private double[] array;
    private double output;
    Thread thread;

    public PISumationThread(double[] array){
        this.array = array;
        output =1;
        thread = new Thread(this);
    }
    @Override
    public void run() {
        for(int i=0; i<array.length; i++){
            output+=array[i];
        }
        System.out.println(4.0*output);
    }

    public double getOutput(){
        return output;
    }

    public void start(){
        thread.start();
    }
}
