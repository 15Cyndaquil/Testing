package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public interface CoinStackInterface {
    void push(int data);
    void pop();
    boolean isFull();
    boolean isEmpty();
    int top();
    int size();
}
