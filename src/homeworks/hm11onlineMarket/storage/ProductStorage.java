package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.ProductType;
import homeworks.hm11onlineMarket.exeption.OutOfStockException;
import homeworks.hm11onlineMarket.model.Product;

public class ProductStorage {
    private Product[] products = new Product[10];
    private int size;


    public void addProduct(Product product) {
        if (products.length == size) {
            extend();
        }
        products[size++] = product;
    }

    public void deleteProductById(String productId) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
                for (int j = i; j < size; j++) {
                    products[j] = products[j + 1];
                }
                products[size - 1] = null;
                size--;
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Invalid user id, please try again");
        }
    }

    public int toCountProductPriceByQuantity(int quantity) throws OutOfStockException {
        for (int i = 0; i < size; i++) {
            if (products[i].getStockQty() > quantity) {
                return (int) (products[i].getPrice() * quantity);
            }
        }
        throw new OutOfStockException(quantity + " this quantity dose not available, please try another quantity");
    }

    public void printAllProducts() {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (size >= 1) {
                System.out.println(products[i]);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Not products at the moment");
        }
    }

    public void searchProduct(String searchCriteria) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product.getId().equals(searchCriteria)
                    || product.getName().contains(searchCriteria)
                    || product.getDescription().contains(searchCriteria)) {
                System.out.println(product);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Product does not found");
        }
    }

    public void handleDelivery(Product product, int deliveredQuantity) {
        if (product.getStockQty() >= deliveredQuantity) {
            product.setStockQty(product.getStockQty() - deliveredQuantity);
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    public void printAllProductType() {
        ProductType[] productTypes = ProductType.values();
        for (ProductType productType : productTypes) {
            System.out.println(productType);
        }
    }

    public Product getProductById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
                return products[i];
            }
        }
        return null;
    }

    private void extend() {
        Product[] tmp = new Product[products.length + 10];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
    }
}
