package test.PinCPU;

/**
 * Created by Cyndaquil on 6/10/2017.
 */
public class SumationThread implements Runnable {
    @Override
    public void run() {
            short aShort = 0;
            while (aShort < Short.MAX_VALUE) {
                aShort++;
            }
    }

}
