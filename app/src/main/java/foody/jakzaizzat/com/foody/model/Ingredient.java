package foody.jakzaizzat.com.foody.model;

public class Ingredient {
    String name;
    double price;
    int usage;
    double cost;
    String category;

    public Ingredient(String name, double price, int usage, double cost, String category){
        this.name = name;
        this.price = price;
        this.usage = usage;
        this.cost = cost;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
