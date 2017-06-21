package homework.csc202.midterm.problem1;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class LLNode {
    private String data;
    private LLNode node;

    public LLNode(String data){
        this.data = data;
        node = null;
    }

    public LLNode(String data, LLNode node){
        this.data = data;
        this.node = node;
    }

    public String getData() {return data;}
    public LLNode getNode() {return node;}

    public void setData(String data) {this.data = data;}
    public void setNode(LLNode node) {this.node = node;}
}
