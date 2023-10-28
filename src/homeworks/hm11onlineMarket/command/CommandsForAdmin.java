package homeworks.hm11onlineMarket.command;

public interface CommandsForAdmin {
    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";

      static void printCommandsForAdmin() {
        System.out.println(LOGOUT + " - logout");
        System.out.println(ADD_PRODUCT + " - add product");
        System.out.println(REMOVE_PRODUCT_BY_ID + " - remove product by id");
        System.out.println(PRINT_PRODUCTS + " - print products");
        System.out.println(PRINT_USERS + " - print users (only USERS)");
        System.out.println(PRINT_ORDERS + " - print orders");
        System.out.println(CHANGE_ORDER_STATUS + " - change order status");
    }
}
