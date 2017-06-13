package homework.csc202.lab07QueueSimulationV2;

/**
 * Created by 15Cyndaquil on 6/13/2017.
 */
public class Customer {
    int enterTime, leaveTime;

    public Customer(int enterTime){
        this.enterTime=enterTime;
        leaveTime=0;
    }

    public void setLeaveTime(int leaveTime){
        this.leaveTime=leaveTime;
    }

    public int getWaitTime(){
        return (leaveTime-enterTime);
    }

}
