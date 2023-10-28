package homeworks.hm11onlineMarket.command;

public interface CommandsForGlobalMenu {
    String EXIT = "0";
    String LOGIN = "1";
    String REGISTER = "2";

     static void printCommandsForGlobalMenu() {
         System.out.println(EXIT + " For exit");
        System.out.println(LOGIN + " For login");
        System.out.println(REGISTER + " For register");
    }
}
