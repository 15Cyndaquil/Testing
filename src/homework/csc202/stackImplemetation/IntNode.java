package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class IntNode {
    int data;
    IntNode node;

    public IntNode(int data){
        this.data = data;
        node=null;
    }
    public IntNode(int data, IntNode node){
        this.data = data;
        this.node = node;
    }

    public int getData() {return data;}
    public IntNode getNode() {return node;}

    public void setData(int data) {this.data = data;}
    public void setNode(IntNode node) {this.node = node;}
}
