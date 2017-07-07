package homework.csc202.treeData;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 6/28/2017.
 */
public class TreeList {
    private BranchNode list;

    public void add(int data){
        if(isEmpty()){list = new BranchNode(data);}
        else {
            if(data>list.getData()){
                if(list.getRight()!=null){
                    list.getRight().add(data);
                }else {
                    list.setRight(new BranchNode(data));
                }
            }else {
                if(list.getLeft()!=null){
                    list.getLeft().add(data);
                }else {
                    list.setLeft(new BranchNode(data));
                }
            }
        }
    }
    public void println(){
       list.println();
       System.out.print("\n");
    }
    public void print(){list.print();}
    public int size(){return list.size();}
    public boolean isEmpty(){return list==null;}
    public int getMaxHeight(){return getMaxHeightHelper(list, 0, 0);}

    public void reOrginize(){
        ArrayList<Integer> current = intList();
        list = null;
        reOrginizeHelper(current);
    }
    public void remove(int data){
        ArrayList<Integer> current = intList();
        if(current.contains(data)){
            current.remove(Integer.valueOf(data));
            if(current.size()==0){
                list=null;
            }else {
                list = new BranchNode(current.get(current.size() / 2));
                current.remove(current.get(current.size()/2));
                current.trimToSize();
                reOrginizeHelper(current);
            }
        }
    }

    public void displayTreeH(){displayTreeHHelper(list,0);}
    public void displayTreeV(){
        int large = String.valueOf(intList().get(intList().size()-1)).length()+1;
        int sHeight = getMaxHeightHelper(list, 0, 0);
        ArrayList[] array = new ArrayList[sHeight+1];
        displayTreeVHelper(list, 0, array, (int) Math.pow(2, sHeight), large);
        System.out.println(sHeight);
        for(int i=0; i<array.length; i++){
            StringBuilder out = new StringBuilder();
            for(int x=0; x<(int)Math.pow(2,sHeight-i); x++){
                for(int y=0; y<large; y++){
                    out.append(" ");
                }
            }
            out.append(array[i].toString());
            int index = out.indexOf(", ");
            while(index!=-1){
                out.replace(index, index+1, "");
                index = out.indexOf(", ");
            }
            index = out.indexOf("[");
            while(index!=-1){
                out.replace(index, index+1, "");
                index = out.indexOf("[");
            }
            index = out.indexOf("]");
            while(index!=-1){
                out.replace(index, index+1, "");
                index = out.indexOf("]");
            }
            System.out.println(out);
        }
    }

    private void displayTreeVHelper(BranchNode node, int count, ArrayList[] array, int maxCount, int large){
        if(node!=null){
            if(node.getLeft()!=null){
                displayTreeVHelper(node.getLeft(), count+1, array, maxCount, large);
            }else if(array.length!=count+1){
                displayTreeVHelper2( count+1, array, maxCount, large);
            }
            if(array[count]!=null) {
                int spaceAdd = maxCount;
                for (int i = 0; i < count; i++) {
                    spaceAdd = spaceAdd - 1;
                    spaceAdd = spaceAdd / 2;
                }
                for(int i=0; i<spaceAdd; i++){
                    array[count].add(String.format("%-"+large+"s","")+String.format("%-"+(large-1)+"s",""));
                }
                array[count].add(String.format("%-"+large+"s",node.getData())+String.format("%-"+(large-1)+"s",""));
            }else {
                array[count] = new ArrayList();
                array[count].add(String.format("%-"+large+"s",node.getData())+String.format("%-"+(large-1)+"s",""));
            }
            if(node.getRight()!=null){
                displayTreeVHelper(node.getRight(), count+1, array, maxCount, large);
            }else if(array.length!=count+1){
                displayTreeVHelper2(count+1, array, maxCount, large);
            }
        }
    }
    private void displayTreeVHelper2(int count, ArrayList[] array, int maxCount, int large) {
        if(array.length!=count+1){
            displayTreeVHelper2(count+1, array, maxCount, large);
        }
        if (array[count] != null) {
            int spaceAdd = maxCount;
            for (int i = 0; i < count; i++) {
                spaceAdd = spaceAdd - 1;
                spaceAdd = spaceAdd / 2;
            }
            for (int i = 0; i < spaceAdd; i++) {
                array[count].add(String.format("%-"+large+"s","")+String.format("%-"+(large-1)+"s",""));
            }
            array[count].add(String.format("%-"+large+"s","")+String.format("%-"+(large-1)+"s",""));
        } else {
            array[count] = new ArrayList();
            array[count].add(String.format("%-"+large+"s","")+String.format("%-"+(large-1)+"s",""));
        }
        if (array.length != count + 1) {
            displayTreeVHelper2(count + 1, array, maxCount, large);
        }
    }
    private void displayTreeHHelper(BranchNode node, int count){
        if(node!=null){
            if(node.getLeft()!=null){
                displayTreeHHelper(node.getLeft(), count+1);
            }
            for(int i=0; i<count; i++){
                System.out.print("-");
            }

            System.out.println(node.getData());
            if(node.getRight()!=null){
                displayTreeHHelper(node.getRight(), count+1);
            }
        }
    }


    private int getMaxHeightHelper(BranchNode node, int count, int max){
        int left, right;
        left = right = 0;
        if(node!=null){
            if(node.getRight()!=null) {
                right = getMaxHeightHelper(node.getRight(), count+1, max);
            }
            max = count;
            if(node.getLeft()!=null) {
                left = getMaxHeightHelper(node.getLeft(), count+1, max);
            }
        }
        if(max<left) max = left;
        if(max<right) max = right;
        return max;
    }
    private ArrayList<Integer> intList(){
        ArrayList<Integer> output = new ArrayList<Integer>();
        list.intList(output);
        return output;
    }
    private void reOrginizeHelper(ArrayList<Integer> current) {
        if (current.size() <= 2) {
            if(current.size()==2){
                add(current.get(0));
                add(current.get(1));
            }else {
                add(current.get(0));
            }
        } else {
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            add(current.get(current.size() / 2));
            current.remove(current.size() / 2);
            int mid = current.size()/2;
            for(int i=0; i<mid; i++){
                left.add(current.get(i));
            }
            for (int i=mid; i<current.size(); i++){
                right.add(current.get(i));
            }

            if (left.size() != 0)
                reOrginizeHelper(left);
            if (right.size() != 0)
                reOrginizeHelper(right);
        }
    }
    private void bubbleSort(ArrayList<Integer> array) {
        for (int n = 0; n < array.size(); n++) {
            for (int i = 0; i < array.size(); i++) {
                if (i + 1 != array.size()) {
                    if (array.get(i) > array.get(i + 1)) {
                        int tmp = array.get(i + 1);
                        array.set(i + 1, array.get(i));
                        array.set(i, tmp);
                    }
                }
            }
        }
    }

}
