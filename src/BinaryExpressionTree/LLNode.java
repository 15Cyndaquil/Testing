package BinaryExpressionTree;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class LLNode {
    private TreeNode data;
    private LLNode node;

    public LLNode(TreeNode data){
        this.data = data;
        node = null;
    }

    public LLNode(TreeNode data, LLNode node){
        this.data = data;
        this.node = node;
    }

    public TreeNode getData() {return data;}
    public LLNode getNode() {return node;}

    public void setData(TreeNode data) {this.data = data;}
    public void setNode(LLNode node) {this.node = node;}
}
