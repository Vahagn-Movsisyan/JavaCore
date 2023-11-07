package homeworks.hm11onlineMarket.util;

import homeworks.hm11onlineMarket.storage.OrderStorage;
import homeworks.hm11onlineMarket.storage.ProductStorage;
import homeworks.hm11onlineMarket.storage.UserStorage;

import java.io.*;

public abstract class StorageSerializeUtil {

    private static final String USER_FILE_PATH = "\\AllJavaProjects\\JavaCore\\src\\homeworks\\hm11onlineMarket\\data\\userStorage.dat";
    private static final String PRODUCT_FILE_PATH = "\\AllJavaProjects\\JavaCore\\src\\homeworks\\hm11onlineMarket\\data\\productStorage.dat";
    private static final String ORDER_FILE_PATH = "\\AllJavaProjects\\JavaCore\\src\\homeworks\\hm11onlineMarket\\data\\orderStorage.dat";

    public static void serializeUserStorage(UserStorage userStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            objectOutputStream.writeObject(userStorage);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static UserStorage deserializeUserStorage() {
        File file = new File(USER_FILE_PATH);

        if (!file.exists()) {
            return new UserStorage();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            Object o = objectInputStream.readObject();
            if (o instanceof UserStorage userStorage) {
                return userStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
        return new UserStorage();
    }

    public static void serializeProductStorage(ProductStorage productStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE_PATH))) {
            objectOutputStream.writeObject(productStorage);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static ProductStorage deserializeProductStorage() {
        File file = new File(PRODUCT_FILE_PATH);

        if (!file.exists()) {
            return new ProductStorage();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PRODUCT_FILE_PATH))) {
            Object o = objectInputStream.readObject();
            if (o instanceof ProductStorage productStorage) {
                return productStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
        return new ProductStorage();
    }


    public static void serializeOrderStorage(OrderStorage orderStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ORDER_FILE_PATH))) {
            objectOutputStream.writeObject(orderStorage);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static OrderStorage deserializeOrderStorage() {
        File file = new File(ORDER_FILE_PATH);

        if (!file.exists()) {
            return new OrderStorage();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ORDER_FILE_PATH))) {
            Object o = objectInputStream.readObject();
            if (o instanceof OrderStorage orderStorage) {
                return orderStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
        return new OrderStorage();
    }
}
