package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.enums.PaymentMethod;
import homeworks.hm11onlineMarket.model.Order;

public class OrderStorage {
    private Order[] orders = new Order[10];
    private int size;

    public void cancelOrderById(int orderId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (orders[i].getId() == orderId) {
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

    public void printAllPaymentMet() {
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println(paymentMethod);
        }
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
