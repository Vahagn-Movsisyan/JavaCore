package homeworks.hm11onlineMarket.model;

import homeworks.hm11onlineMarket.enums.PaymentMethod;

import javax.xml.crypto.Data;

public class Order {
    private int id;
    private User user;
    private Product product;
    private Data data;
    private double price;
    private int quantity;
    private PaymentMethod paymentMethod;

    public Order(int id, User user, Product product, Data data, double price, int quantity, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.data = data;
        this.price = price;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", data=" + data +
                ", price=" + price +
                ", quantity=" + quantity +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
