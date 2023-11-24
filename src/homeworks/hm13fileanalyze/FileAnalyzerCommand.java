package homeworks.hm13fileanalyze;

public interface FileAnalyzerCommand {
    String EXIT = "0";
    String WORD_MAP = "1";
    String TOTAL_WORD_COUNT = "2";
    String UNIQUE_WORD_COUNT = "3";
    String TOP_FREQUENT_WORDS = "4";
    String COUNT_WORD_OCCURRENCES = "5";

    static void printCommands() {
        System.out.println("For EXIT " + EXIT);
        System.out.println("For WORD_MAP " + WORD_MAP);
        System.out.println("For TOTAL_WORD_COUNT " + TOTAL_WORD_COUNT);
        System.out.println("For UNIQUE_WORD_COUNT " + UNIQUE_WORD_COUNT);
        System.out.println("For TOP_FREQUENT_WORDS " + TOP_FREQUENT_WORDS);
        System.out.println("For COUNT_WORD_OCCURRENCES " + COUNT_WORD_OCCURRENCES);
    }
}
