package homeworks.hm11onlineMarket.model;

import homeworks.hm11onlineMarket.model.enums.ProductType;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private int stockQty;
    private String name;
    private String description;
    private double price;
    private ProductType productType;

    public Product(String id, int stockQty, String name, String description, double price, ProductType productType) {
        this.id = id;
        this.stockQty = stockQty;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productType = productType;
    }

    public Product() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", stockQty=" + stockQty +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
