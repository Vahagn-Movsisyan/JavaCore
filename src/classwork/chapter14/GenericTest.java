package classwork.chapter14;

import homeworks.hm11onlineMarket.model.Order;
import homeworks.hm11onlineMarket.model.Product;
import homeworks.hm11onlineMarket.model.User;
import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.PaymentMethod;
import homeworks.hm11onlineMarket.model.enums.ProductType;
import homeworks.hm11onlineMarket.model.enums.UserType;

import java.util.Date;
public class GenericTest {
    public static void main(String[] args) {
        GenericExample<User> userGenericExample = new GenericExample<>();
        GenericExample<Product> productGenericExample = new GenericExample<>();
        GenericExample<Order> orderGenericExample = new GenericExample<>();

        User user = new User("12345", "Max", "a@mail.ru", "12345678", UserType.ADMIN);
        Product product = new Product("123456", 35, "Iphone 15", "New", 1500, ProductType.ELECTRONICS);
        Order order = new Order("1234567", user, product, new Date(), 7500, 5, OrderStatus.NEW, PaymentMethod.CARD);

        userGenericExample.add(user);
        productGenericExample.add(product);
        orderGenericExample.add(order);

        userGenericExample.print();
        productGenericExample.print();
        orderGenericExample.print();
    }
}
