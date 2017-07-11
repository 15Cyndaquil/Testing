package BinaryExpressionTree;

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

            System.out.println(node.toString());
            TreeNode tmp = new TreeNode(node.get(node.size()-1));
            for(int i=node.size()-2; i>=0; i--){
                if(tmp.getLeft()==null){
                    tmp.setLeft(new TreeNode(node.get(i)));
                }else{
                    tmp.setRight(new TreeNode(node.get(i)));
                }
            }
            treeStack.push(new LLNode(tmp));


            if(index>=2) {
                inSep.remove(index);
                inSep.remove(index-1);
                inSep.remove(index-2);
            }else if(index!=0){
                System.out.println(index);
                inSep.remove(index);
                inSep.remove(index-1);
            }else {
                inSep.clear();
            }
        }
        while(!treeStack.isEmpty()){
//            root =
        }


    }

    public void display(){
        displayHelper(root);
    }
    private void displayHelper(TreeNode node){
        if(node!=null){
            if(node.getRight()!=null){
                displayHelper(node.getRight());
            }
            System.out.println(node.getValue());
            if(node.getLeft()!=null){
                displayHelper(node.getLeft());
            }
        }
    }
    public void inorderTraverse(){

    }

    public void preorderTraverse(){

    }

    public String evaluateTree(){


        return "";
    }
  /*  enter your instance methods here.
      buildTree, display, inorderTraverse,
      preorderTraverse, evaluateTree  */


}
