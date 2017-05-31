package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public interface NumberStack {
    void push(int node);
    int top();
    void pop();
    boolean isFull();
    boolean isEmpty();
    String printStack();
}
