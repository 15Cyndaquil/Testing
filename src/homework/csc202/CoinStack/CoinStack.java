package homework.csc202.CoinStack;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class CoinStack implements CoinStackInterface {
    Coin coin;

    @Override
    public void push(Coin coin) {
        if(isEmpty()){
            this.coin = coin;
        }else {
            coin.setLink(this.coin);
            this.coin = coin;
        }
    }

    @Override
    public void pop() {
        if(!isEmpty()){
            coin = coin.getLink();
        }
    }
    public boolean isFull() {return false;}

    @Override
    public boolean isEmpty() {return coin ==null;}

    @Override
    public Coin top() {
        if(!isEmpty()){
            return coin;
        }else return null;
    }

    public int size() {
        int count=0;
        Coin tmp = coin;
        while(tmp!=null){
            count++;
            tmp=tmp.getLink();
        }
        return count;
    }
}
