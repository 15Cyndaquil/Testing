package homework.csc202.stackData;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class LLNode {
    private int data;
    private LLNode node;

    public LLNode(int data){
        this.data = data;
        node = null;
    }

    public LLNode(int data, LLNode node){
        this.data = data;
        this.node = node;
    }

    public int getData() {return data;}
    public LLNode getNode() {return node;}

    public void setData(int data) {this.data = data;}
    public void setNode(LLNode node) {this.node = node;}
}
