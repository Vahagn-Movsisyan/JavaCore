package homeworks.hm13fileanalyze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileAnalyzer {
    // Читаем файл, составляем мапу слово-количество и возвращаем ее
    public Map<String, Integer> wordMap(String path) throws IOException {
        File filePath = new File(path);
        Map<String, Integer> wordCountMap = new HashMap<>();

        if (filePath.exists() && filePath.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] splitLine = line.split("\\s+"); // Use \\s+ to separate words
                    for (String word : splitLine) {
                        if (!word.isEmpty() && wordCountMap.containsKey(word)) {
                            wordCountMap.put(word, wordCountMap.get(word) + 1);
                        } else {
                            wordCountMap.put(word, 1);
                        }
                    }
                }
            }
            return wordCountMap;
        }
        return null;
    }

    // Читаем файл, подсчитываем общее количество слов
    public int totalWordCount(String path) throws IOException {
        File filePath = new File(path);
        if (filePath.exists() && filePath.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int totalWordCount = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] splitLine = line.split("\\s+");
                    totalWordCount += splitLine.length;
                }
                return totalWordCount;
            }
        }
        return 0;
    }

    // Читаем файл, подсчитываем количество уникальных слов
    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> uniqalWordMap = wordMap(path);
        return uniqalWordMap.size();
    }

    // Читаем файл, находим топ-N часто встречающихся слов
    public Map<String, Integer> topFrequentWords(String path, int topN) throws IOException {
        Map<String, Integer> topFrequentWordsMap = wordMap(path);
        List<Map.Entry<String, Integer>> sortedEntryList = topFrequentWordsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        Map<String, Integer> sortedMap = sortedEntryList.stream()
                .limit(topN)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
        return sortedMap;
    }

    // Читаем файл, находим количество вхождений слова и возвращаем это число
    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> countWordOccurrencesMap = wordMap(path);
        return countWordOccurrencesMap.get(word);
    }
}
