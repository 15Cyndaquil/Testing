package homework.csc202.lab05QueueSimulationV1;

import homework.csc202.queueData.QueueArray;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class QueueSimTester {
    private static final int SERVINGTIME = 3;
    public static void main(String[] args){
        NumberQueue queue = new NumberQueue(10);
        boolean isInServing=false;
        int remainingTime = 0;
        int served = 0;
        int left = 0;
        int largestQueue = 0;

        for(int i=0; i<480; i++) {
            int size;
            if (1==(int)(Math.random()*5)) {
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
                if(isInServing){
                    if(remainingTime==0){
                        queue.dequeue();
                        isInServing=false;
                        served++;
                    }else{
                        remainingTime--;
                    }
                }else{
                    remainingTime=SERVINGTIME;
                    isInServing=true;
                }
            }
        }

        System.out.println("Number Served: "+served);
        System.out.println("Number left: "+left);
        System.out.println("Largest Queue: "+largestQueue);
    }
}