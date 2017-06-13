package test.PinCPU;

/**
 * Created by Cyndaquil on 6/10/2017.
 * Uses the SummationThread to create a large amount of CPU usage
 */
public class StartLoopThread implements Runnable {
    private volatile Boolean go = true;
    Thread thread, masterThread;

    public StartLoopThread(Thread currentThread){
        this.masterThread = currentThread;
        thread = new Thread(this);
    }
    @Override
    public void run() {
        while(go) {
                Thread go = new Thread(new SummationThread());
                go.start();
                if(!masterThread.isAlive()){
                    stop();
                }
        }
    }


    void stop(){this.go = false;}

    void start(){
       thread.start();
    }
}
