package homework.csc202.lab03ShoppingBag;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public interface ShoppingBagInterface {
    void push(Item item);
    Item top();
    void pop();
    boolean isFull();
    boolean isEmpty();
}
