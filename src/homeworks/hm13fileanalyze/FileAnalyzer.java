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
        Map<String, Integer> stringIntegerMap = wordMap(path);
        int countAllWord = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerMap.entrySet()) {
            if (stringIntegerEntry.getKey().length() != 1) { // Exam Map key is word or letter
                countAllWord += stringIntegerEntry.getValue();
            }
        }
        return countAllWord;
    }

    // Читаем файл, подсчитываем количество уникальных слов
    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> uniqalWordMap = wordMap(path);
        return uniqalWordMap.size();
    }

    // Читаем файл, находим топ-N часто встречающихся слов
    public Map<String, Integer> topFrequentWords(String path, int topN) throws IOException {
        Map<String, Integer> topFrequentWordsMap = wordMap(path);
        List<Map.Entry<String, Integer>> topFrequentWordsList = new ArrayList<>(topFrequentWordsMap.entrySet());
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        topFrequentWordsList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < topN; i++) {
            Map.Entry<String, Integer> stringIntegerEntry = topFrequentWordsList.get(i);
            sortedMap.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
        return sortedMap;
    }

    // Читаем файл, находим количество вхождений слова и возвращаем это число
    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> countWordOccurrencesMap = wordMap(path);
        return countWordOccurrencesMap.get(word);
    }
}
