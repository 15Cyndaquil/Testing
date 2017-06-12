package test.PinCPU;

/**
 * Created by Cyndaquil on 6/10/2017.
 */
public class StartLoopThread implements Runnable {
    private volatile Boolean go = true;
    @Override
    public void run() {
        while(go) {
                Thread go = new Thread(new SumationThread());
                go.start();
        }
    }

    public void setGo(Boolean go){
        this.go = go;
    }
}
