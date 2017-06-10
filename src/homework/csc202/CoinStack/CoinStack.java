package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class CoinStack implements CoinStackInterface {
    private Coin coin;

    @Override
    public void push(Coin coin) {
        coin.setLink(this.coin);
        this.coin = coin;
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            coin = coin.getLink();
        }
    }

    @Override
    public boolean isEmpty() {
        return coin == null;
    }

    @Override
    public Coin top() {return coin;}
}
