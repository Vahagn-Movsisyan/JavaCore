package classwork.collection.compareAndCoparator;

import java.util.Set;
import java.util.TreeSet;

public class CompareExample {
    public static void main(String[] args) {
        Set<Product> products = new TreeSet<>();

        products.add(new Product("Iphone 15 pro", 250, 1350));
        products.add(new Product("Ipad 19", 200, 1950));
        products.add(new Product("Watch 9", 1500, 750));
        products.add(new Product("Macbook 16 pro", 150, 3500));

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
