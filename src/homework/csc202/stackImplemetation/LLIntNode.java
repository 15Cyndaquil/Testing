package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class LLIntNode {
    int data;
    LLIntNode node;

    public LLIntNode(int data){
        this.data = data;
        node=null;
    }
    public LLIntNode(int data, LLIntNode node){
        this.data = data;
        this.node = node;
    }

    public int getData() {return data;}
    public LLIntNode getNode() {return node;}

    public void setData(int data) {this.data = data;}
    public void setNode(LLIntNode node) {this.node = node;}
}
