package homework.csc202.BinaryExpressionTree;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
/**
 * Created by 15Cyndaquil on 7/11/2017.
 */


/*******************
 Represents a binary expression tree.
 The BXT can build itself from a postorder expression.  It can
 evaluate and print itself. It also prints an inorder string and a preorder string.
 **********************/
class BXT {
    private int count;
    private TreeNode root;

    public BXT() {
        count = 0;
        root = null;
    }

    public void buildTree(String input){
        ArrayList<String> inSep = new ArrayList<>();
        Scanner scan = new Scanner(input).useDelimiter(" ");
        while(scan.hasNext()){
            inSep.add(scan.next());
        }
        LLStack treeStack = new LLStack();
        while(inSep.size()!=0){
            int[] op = new int[4];
            op[0] = inSep.indexOf("+");
            op[1] = inSep.indexOf("-");
            op[2] = inSep.indexOf("*");
            op[3] = inSep.indexOf("/");
            int index = inSep.size();
            for(int i=0; i<op.length; i++){
                if(op[i]!=-1) {
                    index = Math.min(index, op[i]);
                }
            }
            ArrayList<String> node = new ArrayList<>();
            if(index>=2) {
                for (int i = index-2; i <= index; i++) {
                    node.add(inSep.get(i));
                }
            }else {
                for (int i = 0; i <= index; i++) {
                    node.add(inSep.get(i));
                }
            }
            TreeNode tmp = new TreeNode(node.get(node.size()-1));
            for(int i=node.size()-2; i>=0; i--) {
                if (tmp.getRight() == null) {
                    tmp.setRight(new TreeNode(node.get(i)));
                } else {
                    tmp.setLeft(new TreeNode(node.get(i)));
                }
            }
            treeStack.push(new LLNode(tmp));
            if(index>=2) {
                inSep.remove(index);
                inSep.remove(index-1);
                inSep.remove(index-2);
            }else if(index!=0){
                inSep.remove(index);
                inSep.remove(index-1);
            }else {
                inSep.clear();
            }
        }
        int size = treeStack.size();
        for(int i=0; i<size; i++){
            if(root!=null){
                buildHelper(root, treeStack.top());
                treeStack.pop();
            }else {
                root = treeStack.top();
                treeStack.pop();
            }
        }


    }
    private void buildHelper(TreeNode node, TreeNode toAdd){
        if(node.getLeft()==node.getRight()){
            node.setRight(toAdd);
        }else if(node.getLeft()==null){
            node.setLeft(toAdd);
        }else {
            buildHelper(node.getLeft(), toAdd);
        }
    }

    public void display(){
        displayHelper(root, 0);
    }
    private void displayHelper(TreeNode node, int count){
        if(node!=null){
            if(node.getLeft()!=null){
                displayHelper(node.getRight(), count+1);
            }
            for(int i=0; i<count; i++){
                System.out.print("    ");
            }
            System.out.println(String.format("%2s",node.getValue()));
            if(node.getRight()!=null){
                displayHelper(node.getLeft(), count+1);
            }
        }
    }
    public void inorderTraverse(){
        StringBuilder tree = new StringBuilder();
        evaluateHelper(root, tree, 0, "");
        tree = infixOrder(tree);
        System.out.println(tree);
    }

    public void preorderTraverse(){
        StringBuilder out = new StringBuilder();
        preorderHelper(root, out);
        System.out.println(out.toString());
    }
    private void preorderHelper(TreeNode node, StringBuilder out) {
        if (node != null) {
            out.append(node.getValue()+" ");
            if (node.getLeft() != null) {
                preorderHelper(node.getLeft(), out);
            }
            if (node.getRight() != null) {
                preorderHelper(node.getRight(), out);
            }
        }
    }

    public String evaluateTree() {
        StringBuilder tree = new StringBuilder();
        evaluateHelper(root, tree, 0, "");
        tree = infixOrder(tree);
        try {
            return new ScriptEngineManager().getEngineByName("JavaScript").eval(tree.toString()).toString();
        } catch (ScriptException e) {
            return "";
        }
    }
    private void evaluateHelper(TreeNode node, StringBuilder tree, int count, String type){
        if(node!=null){
            if(node.getLeft()!=null){
                evaluateHelper(node.getRight(), tree, count+1, "L");
            }
            String va = node.getValue().toString();
            if(va.equals("-")||va.equals("+")||va.equals("/")||va.equals("*")){
                tree.append(node.getValue());
            }else if(type.equals("L")) {
                    tree.append(" ) ");
                tree.append(" "+node.getValue()+" ");
            }else {
                tree.append(" "+node.getValue()+" ");
                for(int i=1; i<count; i++) {
                    tree.append(" ( ");
                }
            }


            if(node.getRight()!=null){
                evaluateHelper(node.getLeft(), tree, count+1, "R");
            }
        }
    }

    private StringBuilder infixOrder(StringBuilder tree){
        int left, right;
        if (tree.indexOf(")") != tree.lastIndexOf(")")) {
            int index = tree.indexOf(")");
            left = 1;
            while (index != tree.lastIndexOf(")")) {
                left++;
                index = tree.indexOf(")", index + 1);
            }
        } else if (tree.indexOf(")") != -1) {
            left = 1;
        } else left = 0;
        if (tree.indexOf("(") != tree.lastIndexOf("(")) {
            int index = tree.indexOf(")");
            right = 1;
            while (index != tree.lastIndexOf("(")) {
                right++;
                index = tree.indexOf("(", index + 1);
            }
        } else if (tree.indexOf("(") != -1) {
            right = 1;
        } else right = 0;

        if (right < left) {
            for (int i = right; i < left; i++) {
                tree.append("(");
            }
        }

        Scanner scan = new Scanner(tree.toString()).useDelimiter(" ");
        tree = new StringBuilder("");
        while(scan.hasNext()){
            String next = scan.next();

            tree = new StringBuilder(next+tree.toString());
        }

        return tree;
    }
  /*  enter your instance methods here.
      buildTree, display, inorderTraverse,
      preorderTraverse, evaluateTree  */
}
