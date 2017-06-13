package homework.csc202.lab07QueueSimulationV2;

/**
 * Created by 15Cyndaquil on 6/13/2017.
 */
public class CustomerQueue {

    private Customer[] data;
    private int front, rear, numberOfItems, capacity;
    public CustomerQueue(int cap){
        front=rear=numberOfItems=0;
        data=new Customer[cap];
        capacity=cap;
    }
    public boolean isEmpty(){
        return numberOfItems==0;
    }
    public boolean isFull(){
        return numberOfItems==capacity;
    }

    public int size(){
        return numberOfItems;
    }
    public void enqueue(Customer val){
        if(!isFull()){
            data[rear]=val;
            rear= ++rear % capacity;
            numberOfItems++;
        }else{
            System.out.println("it is full, find another restaurant!");
        }
    }
    public Customer dequeue(){
        if(!isEmpty()){
            Customer val=data[front];
            front = ++front % capacity;
            numberOfItems--;
            return val;
        }else{
            return null;
        }
    }
}
