package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class CoinStack implements CoinStackInterface {
    Node node;

    @Override
    public void push(Coin coin) {
        if(isEmpty()){
            node = new Node(coin);
        }else {
            node = new Node(coin, node);
        }
    }

    @Override
    public void pop() {
        if(!isEmpty()){
            node = node.getNode();
        }
    }
    public boolean isFull() {return false;}

    @Override
    public boolean isEmpty() {return node==null;}

    @Override
    public Coin top() {
        if(!isEmpty()){
            return node.getData();
        }else return null;
    }

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
