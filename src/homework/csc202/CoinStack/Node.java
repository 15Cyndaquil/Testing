package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class Node {
    private Coin coin;
    private Node node;

    public Node(Coin coin){
        this.coin = coin;
        node = null;
    }

    public Node(Coin coin, Node node){
        this.coin = coin;
        this.node = node;
    }

    public Coin getData() {return coin;}
    public Node getNode() {return node;}

    public void setData(Coin coin) {this.coin = coin;}
    public void setNode(Node node) {this.node = node;}
}
