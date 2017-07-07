package inventory;

/**
 * Created by Cyndaquil on 6/12/2017.
 */
public class Product{
    String upc, model, itemNumber;
    StringBuilder name, category;
    double priceReg, priceCur, cost;


    //Use if product IS for sale
    public Product(StringBuilder name,StringBuilder category, String model, String upc, String itemNumber, double cost, double priceReg, double priceCur){
        this.name = name;
        this.category = category;
        this.model = model;
        this.upc = upc;
        this.itemNumber = itemNumber;
        this.cost = cost;
        this.priceReg = priceReg;
        this.priceCur = priceCur;
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
    public double getPriceReg() {return priceReg;}
    public double getPriceCur() {return priceCur;}
    public double getCost() {return cost;}

    public void setName(StringBuilder name) {this.name = name;}
    public void setCategory(StringBuilder category) {this.category = category;}
    public void setPriceReg(double priceReg) {this.priceReg = priceReg;}
    public void setPriceCur(double priceCur) {this.priceCur = priceReg;}
    public void setCost(double cost) {this.cost = cost;}

    protected void setUpc(String upc) {this.upc = upc;}
    protected void setModel(String model) {this.model = model;}
    protected void setItemNumber(String itemNumber) {this.itemNumber = itemNumber;}
}
