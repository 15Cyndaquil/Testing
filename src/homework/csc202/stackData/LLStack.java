package homework.csc202.stackData;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class LLStack {
    LLNode top;

    public void push(LLNode llNode) {
        if (isEmpty()){
            top = llNode;
        }
        else if(!isFull()){
            top = new LLNode(llNode.getData(), top);
        }
    }
    public int top(){
        if(isEmpty()) return -1;
        else return top.getData();
    }
    public void pop(){
        if(!isEmpty()){
            top = top.getNode();
        }
    }
    public boolean isFull(){return false;}
    public boolean isEmpty(){return top ==null;}
}
