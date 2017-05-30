package homework.csc202.stackData;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public class Stack {
    private int[] data;
    private int CAP;
    private int index = -1;

    public Stack(int CAP){
        this.CAP = CAP;
        data = new int[this.CAP];
    }


    public boolean isEmpty(){return index == -1;}
    public boolean isFull(){return index==(CAP-1);}
    public int size(){return index+1;}

    public void push(int val){
        if(!isFull()) data[++index] = val;
        else System.out.println("Stack is full");
    }

    public void pop(){if(!isEmpty()) index--;}

    public int top(){
        if(!isEmpty()){
            return data[index];
        }else return -1;
    }
}
