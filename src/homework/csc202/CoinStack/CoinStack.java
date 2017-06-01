package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class CoinStack implements CoinStackInterface {
    Node node;

    @Override
    public void push(int data) {
        if(isEmpty()){
            node = new Node(data);
        }else {
            node = new Node(data, node);
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
        Node tmp = node;
        while(tmp!=null){
            count++;
            tmp=tmp.getNode();
        }
        return count;
    }
}
