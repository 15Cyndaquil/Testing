package homework.csc202.lab12TreeImplementation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 6/28/2017.
 */
    public class MyTree {

    private TreeNode root;

    public MyTree() {
        root = null;
    }

    public void remove(int data) {
        //implement this method to remove a node with the same data value

        ArrayList<Integer> list = intList();
        if (list.contains(data)) {
            list.remove(list.indexOf(data));
            if(list.size()!=0){
                root = new TreeNode(list.get(list.size()/2));
                list.remove(list.size()/2);
                reOrginizeHelper(root,list);
            }else {
                root=null;
            }

        }
    }

    public void printReverse() {
        //implement this method to print data in descending order
        printReverseHelper(root);
        System.out.print("\n");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(TreeNode node) {
        if (node == null) return 0;
        else return 1 + sizeHelper(node.getLeft()) + sizeHelper(node.getRight());
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(TreeNode node, int data) {
        if (node == null) return false;
        if (node.getData() == data) return true;
        else if (node.getData() < data)
            return searchHelper(node.getRight(), data);
        else
            return searchHelper(node.getLeft(), data);
    }

    public void add(int data) {
        root = addHelper(root, data);
    }

    private TreeNode addHelper(TreeNode node, int data) {
        if (node == null) node = new TreeNode(data);
        else if (data <= node.getData())
            node.setLeft(addHelper(node.getLeft(), data));
        else
            node.setRight(addHelper(node.getRight(), data));
        return node;
    }

    public void printInorder() {
        printHelper(root);
        System.out.println(" ");
    }

    private void printHelper(TreeNode node) {
        if (node != null) {
            printHelper(node.getLeft());
            System.out.print(node.getData()+", ");
            printHelper(node.getRight());
        }
    }

    private void printReverseHelper(TreeNode node){
        if (node != null) {
            printReverseHelper(node.getRight());
            System.out.print(node.getData()+", ");
            printReverseHelper(node.getLeft());
        }
    }

    private String removeHelperList(TreeNode node){
        StringBuilder list = new StringBuilder();
        if(node!=null){
            list.append(removeHelperList(node.getLeft()));
            list.append(node.getData()+",");
            list.append(removeHelperList(node.getRight()));
        }
        return list.toString();
    }

    private void removeHelperAdd(TreeNode node){

    }

    public void reOrginize(){
        java.util.ArrayList<Integer> current = intList();
        root = new TreeNode(current.get(current.size()/2));
        current.remove(current.size()/2);
        reOrginizeHelper(root,current);
    }

    private java.util.ArrayList<Integer> intList(){
        java.util.ArrayList<Integer> output = new java.util.ArrayList<Integer>();
        intList(output, root);
        return output;
    }

    private void reOrginizeHelper(TreeNode node, java.util.ArrayList<Integer> current){
        double mid = current.size()/2d;
        if(mid<=1){
            for(int i=0; i<current.size(); i++){
                add(current.get(i));
            }
        }else {
            java.util.ArrayList<Integer> left = new java.util.ArrayList<>();
            java.util.ArrayList<Integer> right = new java.util.ArrayList<>();
            add(current.get((int) mid));
            current.remove((int) mid);
            for(int i=0; i<(int) (mid+1); i++){
                left.add(current.get(i));
            }
            for(int i=(int) (mid+1); i<current.size(); i++){
                right.add(current.get(i));
            }
            reOrginizeHelper(node, right);
            reOrginizeHelper(node, left);

        }
    }

    public void intList(java.util.ArrayList<Integer> output, TreeNode node){
        if(node.getLeft()!=null) intList(output, node.getLeft());
        output.add(node.getData());
        if(node.getRight()!=null) intList(output, node.getRight());
    }



    public void displayTree(){
        StringBuilder output = new StringBuilder();
        ArrayList<Integer> master = intList();
        while(root!=null){
            StringBuilder currentLine = getLeafs(root, new StringBuilder(), "c");
            output.append(currentLine.toString()+"\n");
            while(currentLine.indexOf("r")!=-1){
                currentLine.replace(currentLine.indexOf("r"), currentLine.indexOf("r")+1, "");
            }
            while(currentLine.indexOf("l")!=-1){
                currentLine.replace(currentLine.indexOf("l"), currentLine.indexOf("l")+1, "");
            }
            while(currentLine.indexOf("c")!=-1){
                currentLine.replace(currentLine.indexOf("c"), currentLine.indexOf("c")+1, "");
            }
//            System.out.println(currentLine);
            Scanner scan = new Scanner(currentLine.toString());
            while(scan.hasNextInt()){
                int current = scan.nextInt();
                remove(current);
            }
        }
        output.toString();
        System.out.println(output.toString());
        root = new TreeNode(master.get(0));
        for(int i=1; i<master.size(); i++){
            add(master.get(i));
        }
        reOrginize();
    }

    private StringBuilder getLeafs(TreeNode node, StringBuilder count, String way){
        if(node!=null){
            if(node.getRight()!=null){
                count.append(getLeafs(node.getRight(), new StringBuilder(), "l"));
            }
            if(node.getLeft()!=null){
                count.append(getLeafs(node.getLeft(), new StringBuilder(), "r"));
            }
            if(node.getLeft()==null&&node.getRight()==null){
                count.append(node.getData()+way+" ");
            }
        }
        return count;
    }

}

