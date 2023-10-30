package homeworks.hm11onlineMarket;

import homeworks.hm11onlineMarket.command.CommandsForAdmin;
import homeworks.hm11onlineMarket.command.CommandsForGlobalMenu;
import homeworks.hm11onlineMarket.command.CommandsForUser;
import homeworks.hm11onlineMarket.model.enums.OrderStatus;
import homeworks.hm11onlineMarket.model.enums.PaymentMethod;
import homeworks.hm11onlineMarket.model.enums.ProductType;
import homeworks.hm11onlineMarket.model.enums.UserType;
import homeworks.hm11onlineMarket.exeption.OutOfStockException;
import homeworks.hm11onlineMarket.model.Order;
import homeworks.hm11onlineMarket.model.Product;
import homeworks.hm11onlineMarket.model.User;
import homeworks.hm11onlineMarket.storage.OrderStorage;
import homeworks.hm11onlineMarket.storage.ProductStorage;
import homeworks.hm11onlineMarket.storage.UserStorage;
import homeworks.hm11onlineMarket.util.GenerateUUID;

import java.util.Date;
import java.util.Scanner;

public class OnlineMarketMain implements CommandsForGlobalMenu, CommandsForUser, CommandsForAdmin {
    static Scanner scanner = new Scanner(System.in);
    static OrderStorage orderStorage = new OrderStorage();
    static ProductStorage productStorage = new ProductStorage();
    static UserStorage userStorage = new UserStorage();
    static GenerateUUID stringToUUid = new GenerateUUID();
    static int userId = 12345;
    static int productId = 11234;
    static String orderId = stringToUUid.uuid();
    static UserType userOrAdmin;

    public static void main(String[] args) {
        boolean isRune = true;

        while (isRune) {
            CommandsForGlobalMenu.printCommandsForGlobalMenu();
            String choiceGlobalMenu = scanner.nextLine();

            switch (choiceGlobalMenu) {
                case EXIT -> isRune = false;
                case REGISTER -> register();
                case LOGIN -> login();
            }
        }
    }

    private static void userCommands() {
        boolean isRun = true;
        while (isRun) {
            CommandsForUser.printCommandsForUser();
            String choiceUser = scanner.nextLine();
            switch (choiceUser) {
                case CommandsForUser.LOGOUT -> isRun = false;
                case PRINT_ALL_PRODUCTS -> printAllProducts();
                case BUY_PRODUCT -> buyProduct();
                case PRINT_MY_ORDERS -> printUserMyOrder();
                case CANCEL_ORDER_BY_ID -> canselOrderById();
                case SEARCH_PRODUCT -> searchProduct();
            }
        }
    }

    private static void adminCommands() {
        boolean isRun = true;
        while (isRun) {
            CommandsForAdmin.printCommandsForAdmin();
            String choiceAdmin = scanner.nextLine();
            switch (choiceAdmin) {
                case CommandsForAdmin.LOGOUT -> isRun = false;
                case ADD_PRODUCT -> addProduct();
                case REMOVE_PRODUCT_BY_ID -> deleteProductById();
                case PRINT_PRODUCTS -> printAllProducts();
                case PRINT_USERS -> printAllUsers();
                case PRINT_ORDERS -> printAllOrders();
                case CHANGE_ORDER_STATUS -> changeOrderStatus();
            }
        }
    }

    private static void searchProduct() {
        System.out.println("Enter the product(id,name or description)");
        String searchCriteria = scanner.nextLine();
        productStorage.searchProduct(searchCriteria);
    }

    private static void changeOrderStatus() {
        System.out.println("Enter order id:");
        String orderId = scanner.nextLine();
        if (orderStorage.getOrderById(orderId) != null) {
            System.out.println("Enter new status:");
            orderStorage.printAllOrderStatus();
            OrderStatus orderStatus = OrderStatus.valueOf(scanner.nextLine());
            orderStorage.changeOrderStatus(orderStatus, orderId);
        } else System.out.println(orderId + " id dose not found");
    }

    private static void buyProduct() {
        double toCountProductPriceByQuantity;
        System.out.println("Please choice product by id");
        productStorage.printAllProducts();
        int choiceProductById = Integer.parseInt(scanner.nextLine());

        if (productStorage.getProductById(choiceProductById) != null) {
            System.out.println("Please choice quantity product with you want to buy:");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Please choice payment metod:");
            orderStorage.printAllPaymentMet();

            PaymentMethod paymentMethod;
            try {
                toCountProductPriceByQuantity = productStorage.toCountProductPriceByQuantity(quantity);
                paymentMethod = PaymentMethod.valueOf(scanner.nextLine().toUpperCase());
            } catch (OutOfStockException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            System.out.println("Product id - " + choiceProductById);
            System.out.println("Product quantity - " + quantity);
            System.out.println("Product price - " + toCountProductPriceByQuantity);
            System.out.println("Payment metod - " + paymentMethod);
            System.out.println("You accept your order? (yes/no)");
            String acceptOrder = scanner.nextLine();

            if (acceptOrder.equalsIgnoreCase("yes")) {
                User userFromStorage = userStorage.getUserById(userId);
                Product productFromStorage = productStorage.getProductById(productId);
                Date date = new Date();
                if (userFromStorage != null && productFromStorage != null) {
                    Order order = new Order(orderId, userFromStorage, productFromStorage, date, toCountProductPriceByQuantity, quantity, OrderStatus.NEW, paymentMethod);
                    orderStorage.addOrder(order);
                } else return;
                System.out.println("Order placed successfully.");
            } else System.out.println("Payment is cancelled");
        }
    }

    private static void printAllUsers() {
        System.out.println("--------------");
        userStorage.printOnlyAllUsers();
        System.out.println("--------------");
    }

    private static void printAllProducts() {
        System.out.println("--------------");
        productStorage.printAllProducts();
        System.out.println("--------------");
    }

    private static void printAllOrders() {
        System.out.println("--------------");
        orderStorage.printAllOrders();
        System.out.println("--------------");
    }

    private static void printUserMyOrder() {
        System.out.println("--------------");
        orderStorage.printUserMyOrders(userId);
        System.out.println("--------------");
    }

    private static void deleteProductById() {
        printAllProducts();
        System.out.println("Enter product id for delete");
        int productId = Integer.parseInt(scanner.nextLine());
        if (productStorage.getProductById(productId) != null) {
            productStorage.deleteProductById(productId);
            System.out.println("Product with id " + productId + " successful deleted");
        } else System.out.println("Product with id " + productId + " dose not found");
    }

    private static void canselOrderById() {
        System.out.println("Choice order by id:");
        printUserMyOrder();
        String orderId = scanner.nextLine();
        if (orderStorage.getOrderById(orderId) != null) {
            orderStorage.cancelOrderById(orderId);
            System.out.println("Order with id " + orderId + " successful cansel");
        } else System.out.println("Order with id " + orderId + " dose not found");
    }

    private static void addProduct() {
        try {
            System.out.println("Enter product stockQty:");
            int stockQty = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter product name:");
            String name = scanner.nextLine();
            System.out.println("Enter product description:");
            String description = scanner.nextLine();
            System.out.println("Enter product price:");
            double price = Double.parseDouble(scanner.nextLine());
            productStorage.printAllProductType();
            ProductType productType = ProductType.valueOf(scanner.nextLine().toUpperCase());
            Product product = new Product(productId, stockQty, name, description, price, productType);
            productStorage.addProduct(product);
            productId++;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void register() {
        boolean isRegister;

        try {
            System.out.println("You are User or Admin");
            userOrAdmin = UserType.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("You are entered an error, please try again");
            return;
        }
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        isRegister = userStorage.isValidEmail(email);

        if (!isRegister) {
            System.out.println("Invalid email");
            return;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Confirm password:");
        String confirmPassword = scanner.nextLine();

        if (!confirmPassword.equals(password)) {
            return;
        }

        User user = new User(userId, name, email, password, userOrAdmin);
        userStorage.addUser(user);
        userId++;
        System.out.println("Registration successful");
        if (userOrAdmin == UserType.ADMIN) {
            adminCommands();
        } else if (userOrAdmin == UserType.USER) {
            userCommands();
        }
    }

    private static void login() {
        boolean isLogin;
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        isLogin = userStorage.isLoginValid(email, password);
        System.out.println("Login successful");

        if (isLogin) {
            if (userStorage.getUserType(userId) == UserType.ADMIN) {
                adminCommands();
            } else if (userStorage.getUserType(userId) == UserType.USER) {
                userCommands();
            }
        } else System.out.println("Invalid Login, please try again");
    }
}
