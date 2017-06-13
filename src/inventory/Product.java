package inventory;

/**
 * Created by Cyndaquil on 6/12/2017.
 */
public class Product{
    String upc, model, itemNumber;
    StringBuilder name, category;
    double price, cost;


    //Use if product IS for sale
    public Product(StringBuilder name,StringBuilder category, String model, String upc, String itemNumber, double cost, double price){
        this.name = name;
        this.category = category;
        this.model = model;
        this.upc = upc;
        this.itemNumber = itemNumber;
        this.cost = cost;
        this.price = price;
    }
    //Use if product is NOT for sale
    public Product(StringBuilder name, StringBuilder category, String model, String upc, String itemNumber, double cost){
        this.name = name;
        this.category = category;
        this.model = model;
        this.upc = upc;
        this.itemNumber = itemNumber;
        this.cost = cost;
    }

    public String getUpc() {return upc;}
    public String getModel() {return model;}
    public String getItemNumber() {return itemNumber;}
    public StringBuilder getName() {return name;}
    public StringBuilder getCategory() {return category;}
    public double getPrice() {return price;}
    public double getCost() {return cost;}

    public void setName(StringBuilder name) {this.name = name;}
    public void setCategory(StringBuilder category) {this.category = category;}
    public void setPrice(double price) {this.price = price;}
    public void setCost(double cost) {this.cost = cost;}

    protected void setUpc(String upc) {this.upc = upc;}
    protected void setModel(String model) {this.model = model;}
    protected void setItemNumber(String itemNumber) {this.itemNumber = itemNumber;}
}
