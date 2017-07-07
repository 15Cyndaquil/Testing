package homework.csc202.lab07QueueSimulationV2;

/**
 * Created by 15Cyndaquil on 6/13/2017.
 */
public class Customer {
    int enterTime, leaveTime, imageValue;

    public Customer(int enterTime, int imageValue){
        this.imageValue=imageValue;
        this.enterTime=enterTime;
        leaveTime=0;
    }

    public void setLeaveTime(int leaveTime){
        this.leaveTime=leaveTime;
    }

    public int getWaitTime(){
        return (leaveTime-enterTime);
    }

    public int getImageValue(){return imageValue;}

    public String toString(){return String.valueOf(imageValue);}

}
