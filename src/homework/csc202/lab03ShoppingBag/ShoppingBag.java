package homework.csc202.lab03ShoppingBag;

import java.text.DecimalFormat;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public class ShoppingBag implements ShoppingBagInterface {
    Item[] bag;
    float taxRate;
    int cap;
    int index = -1;


    public ShoppingBag(float taxRate, int cap){
        this.taxRate = taxRate;
        this.cap = cap;
        bag = new Item[cap];
    }

    public String bagSummary(){
        StringBuilder output = new StringBuilder();
        float total = 0;
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        output.append("The bag contains:\nName of the Items     Quantity     Subtotal\n");
        for(int i=0; i<size(); i++){
            String itemName = bag[i].getItemName();
            int quantity = bag[i].getQuantity();
            float itemTotal = Float.valueOf(priceFormat.format(bag[i].getRetailPrice()*quantity));
            total = total+itemTotal;
            output.append(itemName);
            for(int fill=0; fill<22-itemName.length(); fill++){
                output.append(" ");
            }
            output.append(quantity);
            for(int fill=0; fill<13-String.valueOf(quantity).length(); fill++){
                output.append(" ");
            }
            output.append("$"+itemTotal+"\n");
        }
        output.append("                      Total:       $"+priceFormat.format(total)+"\n");
        output.append("                   Tax ("+String.valueOf(taxRate).substring(3,4)+"%):       $"+priceFormat.format(total*taxRate)+"\n");
        output.append("                Grand Total:       $"+(priceFormat.format(total+(total)*taxRate)));
        return output.toString();
    }


    @Override
    public void push(Item item) {
        if(!isFull()) bag[++index] = item;
    }

    @Override
    public Item top() {
        if(!isEmpty()) return bag[index];
        else return null;
    }

    @Override
    public void pop() {
        if(!isEmpty()) index--;
    }

    @Override
    public boolean isFull() {return index == cap-1;}

    @Override
    public boolean isEmpty() {return index == -1;}

    public int size(){return index+1;}
}
