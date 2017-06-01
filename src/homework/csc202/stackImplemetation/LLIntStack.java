package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class LLIntStack implements NumberStack {
    LLIntNode node;

    @Override
    public void push(int data) {
        if(isEmpty()){
            node = new LLIntNode(data);
        }else {
            node = new LLIntNode(data, node);
        }
    }

    @Override
    public void pop() {
        if(!isEmpty()){
            node = node.getNode();
        }
    }

    @Override
    public boolean isFull() {return false;}

    @Override
    public boolean isEmpty() {return node==null;}

    @Override
    public int top() {
        if(!isEmpty()){
            return node.getData();
        }else return -1;
    }

    @Override
    public int size() {
        int count=0;
        LLIntNode tmp = node;
        while(tmp!=null){
            count++;
            tmp=tmp.getNode();
        }
        return count;
    }

    @Override
    public String printStack() {
        StringBuilder output = new StringBuilder("");
        LLIntNode tmp = node;
        while(tmp!=null){
            output.append(tmp.getData()+", ");
            tmp=tmp.getNode();
        }
        output.replace(output.length()-2, output.length(),"");
        return output.toString();
    }
}
