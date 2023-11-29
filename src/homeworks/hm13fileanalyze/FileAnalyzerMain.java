package homeworks.hm13fileanalyze;

import java.io.IOException;
import java.util.Scanner;

public class FileAnalyzerMain implements FileAnalyzerCommand {
    static Scanner scanner = new Scanner(System.in);
    static FileAnalyzer fileAnalyzer = new FileAnalyzer();

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            FileAnalyzerCommand.printCommands();
            String choice = scanner.nextLine();
            switch (choice) {
                case EXIT -> isRun = false;
                case WORD_MAP -> wordMap();
                case TOTAL_WORD_COUNT -> totalWordCount();
                case UNIQUE_WORD_COUNT -> uniqueWordCount();
                case TOP_FREQUENT_WORDS -> topFrequentWords();
                case COUNT_WORD_OCCURRENCES -> countWordOccurrences();
                default -> System.out.println("You are entered an error");
            }
        }
    }

    static void wordMap() {
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        try {
            if (fileAnalyzer.wordMap(filePath) != null) {
                System.out.println(fileAnalyzer.wordMap(filePath));
            } else {
                System.out.println("File is empty or not found");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void totalWordCount() {
        System.out.println("Enter the path:");
        String filePath = scanner.nextLine();
        try {
            if (fileAnalyzer.totalWordCount(filePath) != 0) {
                System.out.println(fileAnalyzer.totalWordCount(filePath));
            } else {
                System.out.println("File is empty or not found");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void uniqueWordCount() {
        System.out.println("Enter the path:");
        String filePath = scanner.nextLine();
        try {
            if (fileAnalyzer.uniqueWordCount(filePath) != 0) {
                System.out.println(fileAnalyzer.uniqueWordCount(filePath));
            } else {
                System.out.println("File is empty or not found");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void topFrequentWords() {
        System.out.println("Enter the path:");
        String filePath = scanner.nextLine();
        System.out.println("Enter the top N:");
        try {
            int topN = Integer.parseInt(scanner.nextLine());
            System.out.println(fileAnalyzer.topFrequentWords(filePath, topN));
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    static void countWordOccurrences() {
        System.out.println("Enter the path:");
        String filePath = scanner.nextLine();
        System.out.println("Enter the word:");
        String word = scanner.nextLine();
        try {
            if (fileAnalyzer.countWordOccurrences(filePath, word) != 0) {
                System.out.println(fileAnalyzer.countWordOccurrences(filePath, word));
            }  else {
                System.out.println("File is empty or not found");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
