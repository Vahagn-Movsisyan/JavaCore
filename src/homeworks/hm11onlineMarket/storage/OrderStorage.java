package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.exeption.IdNotFoundException;
import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.PaymentMethod;
import homeworks.hm11onlineMarket.model.Order;
import homeworks.hm11onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class OrderStorage implements Serializable {
    private final List<Order> ORDERS = new ArrayList<>();

    public void cancelOrderById(String orderId) throws IdNotFoundException {
        boolean exist = false;
        for (Order order : ORDERS) {
            if (order.getId().equals(orderId)) {
                order.setOrderStatus(OrderStatus.CANCELED);
                exist = true;
            }
        }
        if (!exist) {
            throw new IdNotFoundException(orderId + " this id dose not found");
        }
    }

    public void changeOrderStatus(OrderStatus orderStatus, String orderId) throws IdNotFoundException {
        ProductStorage productStorage = new ProductStorage();
        boolean exist = false;

        for (Order order : ORDERS) {
            if (order.getId().equals(orderId) && order.getOrderStatus() == OrderStatus.NEW && orderStatus == OrderStatus.DELIVERED) {
                order.setOrderStatus(orderStatus);
                productStorage.handleDelivery(order.getProduct(), order.getQuantity());
                StorageSerializeUtil.serializeOrderStorage(this);
                exist = true;
            }
        }

        if (!exist) {
            throw new IdNotFoundException(orderId + " this id dose not found or order status is delivery or cansel");
        }
    }

    public void printUserMyOrders(String userId) {
        boolean exist = false;
        for (Order order : ORDERS) {
            if (order.getId().equals(userId)) {
                System.out.println(order);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Not orders at the moment");
        }
    }

    public void printOrderStatus() {
        OrderStatus[] orderStatuses = OrderStatus.values();
        for (OrderStatus status : orderStatuses) {
            System.out.println(status);
        }
    }

    public void printAllPaymentMethods() {
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println(paymentMethod);
        }
    }

    public void printAllOrders() {
        boolean exist = false;
        for (Order order : ORDERS) {
            System.out.println(order);
            exist = true;
        }
        if (!exist) {
            System.out.println("Not orders at the moment");
        }
    }

    public Order getOrderById(String orderId) {
        for (Order order : ORDERS) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        ORDERS.add(order);
        StorageSerializeUtil.serializeOrderStorage(this);
    }
}
