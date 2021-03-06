package foody.jakzaizzat.com.foody.model;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Recipe {
    String name;
    double cost;
    int quantity;
    List<Ingredient> list;

    public Recipe(){
    }

    public Recipe(String name, double cost, int quantity, List<Ingredient> list){
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.list = list;
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

    public List<Ingredient> getList() {
        return list;
    }

    public void setList(List<Ingredient> list) {
        this.list = list;
    }
}
