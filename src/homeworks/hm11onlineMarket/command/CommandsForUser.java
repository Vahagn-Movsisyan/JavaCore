package homeworks.hm11onlineMarket.command;

public interface CommandsForUser {
    String LOGOUT = "0";
    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";
    String SEARCH_PRODUCT = "5";

    static void printCommandsForUser() {
        System.out.println(LOGOUT + " - logout");
        System.out.println(PRINT_ALL_PRODUCTS + " - print all products");
        System.out.println(BUY_PRODUCT + " - buy product by product id");
        System.out.println(PRINT_MY_ORDERS + " - print my orders");
        System.out.println(CANCEL_ORDER_BY_ID + " - cancel order by id");
        System.out.println(SEARCH_PRODUCT + " - search product by(id,name or description)");
    }
}
