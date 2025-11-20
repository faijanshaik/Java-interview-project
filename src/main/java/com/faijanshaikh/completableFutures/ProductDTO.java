package main.java.com.faijanshaikh.completableFutures;

public class ProductDTO {
    public int id;
    public String name;
    public String model;
    public int price;
    public boolean inStock;
    public int rating;

    public ProductDTO(){

    }

    public ProductDTO(int id, String name, String model, int price, boolean inStock, int rating) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.inStock = inStock;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", rating=" + rating +
                '}';
    }
}
