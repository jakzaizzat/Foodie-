package foody.jakzaizzat.com.foody.model;

import org.parceler.Parcel;

@Parcel
public class Recipe {
    String name;
    double cost;
    int quantity;

    public Recipe(){
    }

    public Recipe(String name, double cost, int quantity){
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
