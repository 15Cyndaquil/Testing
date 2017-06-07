package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public interface CoinStackInterface{

    void pop();
    void push(Coin coin);
    Coin top();
    boolean isEmpty();
}
