package homework.csc202.queueSimGUI;

import homework.csc202.lab07QueueSimulationV2.Customer;
import homework.csc202.lab07QueueSimulationV2.CustomerQueue;
import homework.csc202.lab07QueueSimulationV2.QueueV2Tester;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.File;

/**
 * Created by 15Cyndaquil on 7/6/2017.
 */
public class QueueUpdateThread implements Runnable{
    private Thread thread;
    private int hours, days;
    private File[] images;
    private SimpleIntegerProperty[] queueImages;
    private QueueV2Tester sim;
    private volatile boolean go;

    public QueueUpdateThread(int hours, int days, File[] images, SimpleIntegerProperty[] queueImages, QueueV2Tester sim, Boolean go){
        this.hours = hours;
        this.days = days;
        this.images = images;
        this.queueImages = queueImages;
        this.sim = sim;
        this.go = go;
        thread = Thread.currentThread();
    }

    @Override
    public void run() {
        while (go) {
            for (int y = 0; y < days; y++) {
                for (int x = 0; x < hours * 60 + 100; x++) {
                    CustomerQueue current = sim.getQueue(x, y);
                    if (current != null && current.size() != 0) {
                        int size = current.size();
                        Customer first = current.dequeue();
                        queueImages[0].setValue(first.getImageValue());
                        for (int i = 1; i < size; i++) {
                            queueImages[i].setValue(current.dequeue().getImageValue());
                        }
                        for (int i = size; i < 10; i++) {
                            queueImages[i].setValue(11);
                        }
                    } else {
                        queueImages[0].setValue(11);
                    }
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(!go){
                        break;
                    }
                }
                if(!go){
                    break;
                }

            }
            go=false;
        }
    }

    public void stop(){
        go = false;
    }
}
