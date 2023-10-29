package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.PaymentMethod;
import homeworks.hm11onlineMarket.model.Order;

public class OrderStorage {
    private Order[] orders = new Order[10];
    private int size;

    public void cancelOrderById(String orderId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                for (int j = i; j < size; j++) {
                    orders[j] = orders[j + 1];
                }
                orders[size - 1] = null;
                size--;
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Invalid order id, please try again");
        }
    }

    public void changeOrderStatus(OrderStatus orderStatus, String orderId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                orders[i].setOrderStatus(orderStatus);
                exist = true;
            }
        }
        if (!exist) System.out.println(orderId + " id dose not found");
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

    public void printUserMyOrders(int userId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().getId() == userId) {
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
    }

    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }
}
