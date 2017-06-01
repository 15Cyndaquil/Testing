package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public interface NumberStack {
    void push(int data);
    void pop();
    boolean isFull();
    boolean isEmpty();
    int top();
    int size();
    String printStack();
}
