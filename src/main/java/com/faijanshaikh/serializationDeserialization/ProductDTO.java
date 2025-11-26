package main.java.com.faijanshaikh.serializationDeserialization;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public transient static String model;
    public transient final int price;
    public boolean inStock;
    public  static int rating;

    public ProductDTO(int id, String name, String model,int price, boolean inStock, int rating) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.inStock = inStock;
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
