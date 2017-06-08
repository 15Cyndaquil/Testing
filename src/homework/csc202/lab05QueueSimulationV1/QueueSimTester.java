package homework.csc202.lab05QueueSimulationV1;

import homework.csc202.queueData.QueueArray;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class QueueSimTester {
    public static void main(String[] args){
        QueueArray queue = new QueueArray(10);
        int served = 0;
        int left = 0;
        int largestQueue = 0;

        for(int i=0; i<480; i++) {
            int tmpInt;
            int size;
            if (0==(int)(Math.random()*5)) {
                if (queue.isFull()) {
                    left++;
                } else {
                    queue.enqueue(i);
                    if (queue.size()>largestQueue) {
                        largestQueue = queue.size();
                    }
                }
            }
            if(!queue.isEmpty()) {
                tmpInt = queue.dequeue();
                size = queue.size();
                if (tmpInt + 3 == i) {
                    served++;
                } else {
                    QueueArray tmpQueue = new QueueArray(10);
                    tmpQueue.enqueue(tmpInt);
                    for (int x = 0; x < size; x++) {
                        tmpQueue.enqueue(queue.dequeue());
                    }
                    queue.enqueue(tmpQueue.dequeue());
                    for (int x = 0; x < size; x++) {
                        queue.enqueue(tmpQueue.dequeue());
                    }
                }
            }
        }

        System.out.println("Number Served: "+served);
        System.out.println("Number left: "+left);
        System.out.println("Largest Queue: "+largestQueue);
    }
}
