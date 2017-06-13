package homework.csc202.lab07QueueSimulationV2;


import homework.csc202.stackImplemetation.LLIntStack;

import java.util.ArrayList;


/**
 * Created by 15Cyndaquil on 6/13/2017.
 */
public class QueueV2Tester {
    private static final int SERVINGTIME = 3;
    private static final int RUN_TIME_MIN =480;
    private static final int DAYS_TO_RUN = 10;
    public static void main(String[] args){
        for(int day=1; day<=DAYS_TO_RUN; day++) {
            CustomerQueue queue = new CustomerQueue(10);
            LLIntStack waitTimeList = new LLIntStack();

            double averageWaitTime;

            int remainingTime, served, left, largestQueue, totalWaitTime, totalRunTime, longestWaitTime, totalCustomers;
            totalCustomers=longestWaitTime=remainingTime=served=left=largestQueue=totalWaitTime=0;

            boolean isInServing=false;


            totalRunTime = RUN_TIME_MIN;
            for (int currentMin = 0; currentMin < totalRunTime; currentMin++) {
                if (currentMin < RUN_TIME_MIN && 1 == (int) (Math.random() * 5)) {
                    totalCustomers++;
                    if (queue.isFull()) {
                        left++;
                    } else {
                        queue.enqueue(new Customer(currentMin));
                        if (queue.size() > largestQueue) {
                            largestQueue = queue.size();
                        }
                    }
                }
                if (!queue.isEmpty()) {
                    if (isInServing) {
                        if (remainingTime == 0) {
                            Customer severed = queue.dequeue();
                            severed.setLeaveTime(currentMin);
                            waitTimeList.push(severed.getWaitTime());
                            isInServing = false;
                            served++;
                        } else {
                            remainingTime--;
                        }
                    } else {
                        remainingTime = SERVINGTIME;
                        isInServing = true;
                    }
                }
                if (currentMin == totalRunTime-1) {
                    if (!queue.isEmpty()) {
                        totalRunTime++;
                    }
                }
            }


            for (int i = 0; i < served; i++) {
                totalWaitTime += waitTimeList.top();
                if(longestWaitTime<waitTimeList.top()){
                    longestWaitTime=waitTimeList.top();
                }
                waitTimeList.pop();
            }
            averageWaitTime = (double) totalWaitTime / served;

            System.out.println("Day: "+day);
            System.out.println("Total customers arrived: "+(served+left)+" "+totalCustomers);
            System.out.println("Number Served: " + served);
            System.out.println("Number Left: " + left);
            System.out.println("Largest Queue: " + largestQueue);
            System.out.println("Longest Wait Time: "+longestWaitTime);
            System.out.println("Average Wait Length: " + averageWaitTime+"\n");
        }
    }
}
