package test.PinCPU;

/**
 * Created by Cyndaquil on 6/10/2017.
 * Made to utilize large amounts of cpu processes
 * while not lasting for long
 */
public class SummationThread implements Runnable {


    @Override
    public void run() {
        int anInt = 0;
        int anInt1 = 0;
        int anInt2 = 0;
        int anInt3 = 0;
        int anInt4 = 0;
        int anInt5 = 0;
            while (anInt < Short.MAX_VALUE) {
                anInt++;
                anInt1++;
                anInt2++;
                anInt3++;
                anInt4++;
                anInt5++;
            }
    }

}
