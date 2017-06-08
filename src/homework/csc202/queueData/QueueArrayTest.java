package homework.csc202.queueData;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class QueueArrayTest {
    public static void main(String[] args){
        QueueArray test = new QueueArray(5);
        test.enqueue(5);
        System.out.println("Size: "+test.size());
        test.enqueue(6);
        test.enqueue(7);
        test.enqueue(8);
        test.enqueue(9);

        test.enqueue(10);

        System.out.println("Size: "+test.size());
        test.dequeue();
        System.out.println("Size: "+test.size());
        test.enqueue(5);
        System.out.println("Size: "+test.size());
        test.dequeue();
        System.out.println("Size: "+test.size());
        test.dequeue();
        System.out.println("Size: "+test.size());
        test.dequeue();
        System.out.println("Size: "+test.size());
        test.dequeue();
        System.out.println("Size: "+test.size());
        test.dequeue();
        System.out.println("Size: "+test.size());
    }
}
