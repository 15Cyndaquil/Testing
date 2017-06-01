package homework.csc202.lab04StackArray;

import homework.csc202.stackImplemetation.NumberStack;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class ArrayIntStack implements NumberStack {
    int[] stack;
    int length;
    int index = -1;

    public ArrayIntStack(int size){
        length = size;
        stack = new int[length];
    }


    @Override
    public void push(int data) {if(!isFull()){stack[++index] = data;}}
    @Override
    public void pop() {if(index!=-1){index--;}}
    @Override
    public boolean isFull() {return index==length-1;}
    @Override
    public boolean isEmpty() {return index==-1;}
    @Override
    public int top() {
        if(!isEmpty()){
            return stack[index];
        }else {
            return -1;
        }
    }
    @Override
    public int size() {return index+1;}
    @Override
    public String printStack() {
        StringBuilder out = new StringBuilder("");
        for(int i=0; i<=index; i++){
            out.append(stack[i]+", ");
        }
        out.replace(out.length()-2, out.length(),"");
        return out.toString();
    }
}
