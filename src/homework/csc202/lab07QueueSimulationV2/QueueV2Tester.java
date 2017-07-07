package homework.csc202.lab07QueueSimulationV2;


import homework.csc202.stackImplemetation.LLIntStack;


/**
 * Created by 15Cyndaquil on 6/13/2017.
 */
public class QueueV2Tester {
    private int servingTime;
    private int hours;
    private int days;
    private CustomerQueue[][] array;

    private double averageWaitTime;
    private int remainingTime, served, left, largestQueue, totalWaitTime, totalRunTime, longestWaitTime, totalCustomers;

    public QueueV2Tester(int hours, int days, int servingTime){
        this.hours=hours;
        this.days=days;
        this.servingTime=servingTime;
        totalCustomers=longestWaitTime=remainingTime=served=left=largestQueue=totalWaitTime=0;
    }

    public void runSimulation() {
        int minsToRun = hours*60;
        array = new CustomerQueue[minsToRun+(100)][days];
        for (int day = 0; day < days; day++) {
            CustomerQueue queue = new CustomerQueue(10);
            LLIntStack waitTimeList = new LLIntStack();


            boolean isInServing = false;
            totalRunTime =minsToRun;
            for (int currentMin = 0; currentMin < totalRunTime; currentMin++) {
                if (currentMin < minsToRun && 1 == (int) (Math.random() * 5)) {
                    totalCustomers++;
                    if (queue.isFull()) {
                        left++;
                    } else {
                        queue.enqueue(new Customer(currentMin, (int) (Math.random() * 11)));
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
                        remainingTime = servingTime;
                        isInServing = true;
                    }
                }
                if (currentMin == totalRunTime - 1) {
                    if (!queue.isEmpty()) {
                        totalRunTime++;
                    }
                }
                array[currentMin][day]= (CustomerQueue) queue.clone();
            }


            for (int i = 0; i < served; i++) {
                totalWaitTime += waitTimeList.top();
                if (longestWaitTime < waitTimeList.top()) {
                    longestWaitTime = waitTimeList.top();
                }
                waitTimeList.pop();
            }
        }
        averageWaitTime = (double) totalWaitTime / served;
    }

    public double getAverageWaitTime() {return averageWaitTime;}
    public int getLongestWaitTime() {return longestWaitTime;}
    public int getTotalCustomers() {return totalCustomers;}
    public int getLeft() {return left;}

    public CustomerQueue getQueue(int min, int day){
        return array[min][day];
    }
}
