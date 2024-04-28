import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = readFile();

        int wordCount = countWords(words);
        System.out.println("Количество слов в файле: " + wordCount);

        String longestWord = findLongestWord(words);
        System.out.println("Самое длинное слово в файле: " + longestWord);

        Map<String, Integer> wordFrequency = calculateWordFrequency(words);
        System.out.println("Частота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static List<String> readFile() {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }

    private static int countWords(List<String> words) {
        return words.size();
    }

    private static String findLongestWord(List<String> words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static Map<String, Integer> calculateWordFrequency(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}