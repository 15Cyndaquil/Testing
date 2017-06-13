package test.PinCPU;

/**
 * Created by Cyndaquil on 6/10/2017.
 * Made to utilize large amounts of cpu processes
 * while not lasting for long
 */
public class SummationThread implements Runnable {


    @Override
    public void run() {
            short aShort = 0;
            while (aShort < Short.MAX_VALUE) {
                aShort++;
            }
    }

}
