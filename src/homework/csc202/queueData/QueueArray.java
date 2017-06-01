package homework.csc202.queueData;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class QueueArray {
    private int[] array;
    private int tail = -1;
    private int head = -1;

    public QueueArray(int size){array = new int[size];}

    public void inQueue(int data){
        if(!isFull()){
            if(isEmpty()){
                head++;
                array[++tail] = data;
            }else {
                if(tail+1==array.length){
                    tail=0;
                    array[tail] = data;
                }else {
                    array[++tail] = data;
                }
            }
        }
    }

    public void deQueue(){
        if(!isEmpty()){
            if(head==tail){
                head =-1;
                tail=-1;
            }else {
                if(head +1==array.length){
                    head =0;
                }else {
                    head++;
                }
            }
        }
    }

    public boolean isFull(){
       if(tail+1==array.length){return head ==0;
       }else {return head == tail + 1;}
    }

    public boolean isEmpty(){
        return head ==-1;
    }

    public int size() {
        if (!isEmpty()) {
            if(tail<head) {
                return array.length - (head-tail-1);
            }else {
                return tail-head+1;
            }
        }else {
            return 0;
        }
    }

    public int first(){
        if(!isEmpty()){
            return array[head];
        }
        else return -10;
    }
}
