package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class NumberNode {
    private int data;
    private NumberNode node;

    public NumberNode(int data){
        this.data = data;
        node = null;
    }
    public NumberNode(int data, NumberNode node){
        this.data = data;
        this.node = node;
    }


    public int getData() {return data;}
    public NumberNode getNode() {return node;}

    public void setData(int data) {this.data = data;}
    public void setNode(NumberNode node) {this.node = node;}
}
