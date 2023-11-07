package homeworks.hm11onlineMarket.model;

import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.PaymentMethod;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String id;
    private User user;
    private Product product;
    private Date date;
    private double price;
    private int quantity;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;

    public Order(String id, User user, Product product, Date data, double price, int quantity, OrderStatus orderStatus, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.date = data;
        this.price = price;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getData() {
        return date;
    }

    public void setData(Date data) {
        this.date = data;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
                "id='" + id + '\'' +
                ", user=" + user +
                ", product=" + product +
                ", date=" + date +
                ", price=" + price +
                ", quantity=" + quantity +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
