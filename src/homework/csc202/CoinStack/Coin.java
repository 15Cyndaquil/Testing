package homework.csc202.CoinStack;

/**
 * Created by 15Cyndaquil on 6/7/2017.
 */
public class Coin{
    int value;
    Coin next;
    public Coin(int value){
        this.value=value;
    }
    public void setLink(Coin coin){
        this.next=coin;
    }
    public Coin getLink(){
        return next;
    }
    public int getValue(){
        return value;
    }
}
