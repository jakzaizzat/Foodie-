package foody.jakzaizzat.com.foody.model;

public class RecipeList {
    String name;
    double cost;
    int quantity;

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

    public RecipeList(String name, double cost, int quantity) {

        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }
}
