package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.PaymentMethod;
import homeworks.hm11onlineMarket.model.Order;
import homeworks.hm11onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {
    private Order[] orders = new Order[10];
    private int size;

    public void cancelOrderById(String orderId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                orders[i].setOrderStatus(OrderStatus.CANCELED);
                exist = true;
                StorageSerializeUtil.serializeOrderStorage(this);
            }
        }
        if (!exist) {
            System.out.println("Invalid order id, please try again");
        }
    }

    public void changeOrderStatus(OrderStatus orderStatus, String orderId) {
        ProductStorage productStorage = new ProductStorage();
        boolean exist = false;

        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId) && orderStatus == OrderStatus.DELIVERED) {
                orders[i].setOrderStatus(orderStatus);
                productStorage.handleDelivery(orders[i].getProduct(), orders[i].getQuantity());
                exist = true;
                StorageSerializeUtil.serializeOrderStorage(this);
            }
        }
        if (!exist) System.out.println(orderId + " id dose not found!");
    }

    public void printUserMyOrders(String userId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().getId().equals(userId) && size >= 1) {
                System.out.println(orders[i]);
            }
        }
        if (!exist) System.out.println("Not orders at the moment");
    }

    public void printAllOrderStatus() {
        OrderStatus[] orderStatuses = OrderStatus.values();
        for (OrderStatus status : orderStatuses) {
            System.out.println(status);
        }
    }

    public void printAllPaymentMet() {
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println(paymentMethod);
        }
    }

    public void printAllOrders() {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (size >= 1) {
                System.out.println(orders[i]);
                exist = true;
            }
        }
        if (!exist) System.out.println("Not orders at the moment");
    }

    public Order getOrderById(String orderId) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                return orders[i];
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        if (orders.length == size) {
            extend();
        }
        orders[size++] = order;
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }
}
