package homework.csc202.lab03ShoppingBag;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public class Item {
    private String itemName;
    private int quantity;
    private float retailPrice;

    public Item(String itemName, int quantity, float retailPrice){
        this.itemName = itemName;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
    }

    public String getItemName() {return itemName;}
    public int getQuantity() {return quantity;}
    public float getRetailPrice() {return retailPrice;}

    public void setItemName(String itemName) {this.itemName = itemName;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setRetailPrice(float retailPrice) {this.retailPrice = retailPrice;}
}
