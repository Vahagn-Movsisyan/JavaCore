package homeworks.hm12FileUtil;

public interface Command {
    String EXIT = "0";
    String SEARCH_FILE = "1";
    String CONTENT_SEARCH = "2";
    String FIND_LINES = "3";
    String PRINT_SIZE_PACKAGE = "4";
    String CREATE_FILE_WITH_CONTENT = "5";

    static void printCommands() {
        System.out.println(EXIT + " - Exit");
        System.out.println(SEARCH_FILE + " - Search file");
        System.out.println(CONTENT_SEARCH + " - Content search");
        System.out.println(FIND_LINES + " - Find lines");
        System.out.println(PRINT_SIZE_PACKAGE + " - Print size package");
        System.out.println(CREATE_FILE_WITH_CONTENT + " - Create file with content");
    }
}

