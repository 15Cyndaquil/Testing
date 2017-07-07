package homework.csc202.treeData;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 6/28/2017.
 */
public class BranchNode {
    private BranchNode left, right;
    private int data;

    public BranchNode(int data){
        this.data = data;
    }

    public void add(int data){
        if(data>this.data){
            if(right!=null){
                right.add(data);
            }else {
                right = new BranchNode(data);
            }
        }else {
            if(left!=null){
                left.add(data);
            }else {
                left = new BranchNode(data);
            }
        }
    }
    public void println(){
        if(left!=null) left.print();
        System.out.print(data+", ");
        if(right!=null) right.print();
    }
    public int size(){
        int count=1;
        if(right!=null) count+=right.size();
        if(left!=null) count+=left.size();
        return count;
    }
    public void print(){
        if(left!=null) left.print();
        System.out.print(data+", ");
        if(right!=null) right.print();
    }

    public void setData(int data) {this.data = data;}
    public void setLeft(BranchNode left) {this.left = left;}
    public void setRight(BranchNode right) {this.right = right;}
    public BranchNode getLeft() {return left;}
    public BranchNode getRight() {return right;}
    public int getData() {return data;}

    public void intList(ArrayList<Integer> output){
        if(left!=null) left.intList(output);
        output.add(data);
        if(right!=null) right.intList(output);
    }
}
