package homework.csc202.queueData;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class QueueArrayTest {
    public static void main(String[] args){
        QueueArray test = new QueueArray(5);
        test.inQueue(5);
        System.out.println("Size: "+test.size());
        test.inQueue(6);
        test.inQueue(7);
        test.inQueue(8);
        test.inQueue(9);

        test.inQueue(10);

        System.out.println("Size: "+test.size());
        System.out.println(test.first());
        test.deQueue();
        System.out.println("Size: "+test.size());
        test.inQueue(5);
        System.out.println("Size: "+test.size());
        System.out.println(test.first());
        test.deQueue();
        System.out.println("Size: "+test.size());
        System.out.println(test.first());
        test.deQueue();
        System.out.println("Size: "+test.size());
        System.out.println(test.first());
        test.deQueue();
        System.out.println("Size: "+test.size());
        System.out.println(test.first());
        test.deQueue();
        System.out.println("Size: "+test.size());
        System.out.println(test.first());
        test.deQueue();
        System.out.println("Size: "+test.size());
    }
}
