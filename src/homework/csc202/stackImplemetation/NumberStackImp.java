package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class NumberStackImp implements NumberStack {
    NumberNode top;

    @Override
    public void push(int node) {
        if (isEmpty()){
            top = new NumberNode(node);
        }
        else if(!isFull()){
            top = new NumberNode(node, top);
        }
    }
    @Override
    public int top(){
        if(!isEmpty()){
            return top.getData();
        }else return -1;
    }
    @Override
    public void pop() {
        if(!isEmpty()){
            top = top.getNode();
        }
    }
    @Override
    public boolean isFull() {
        return false;
    }
    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public String printStack() {
        StringBuilder output = new StringBuilder("");
        NumberNode tmp = top;
        while(tmp!=null){
            output.append(tmp.getData()+", ");
            tmp=tmp.getNode();
        }
        return output.toString();
    }
}
