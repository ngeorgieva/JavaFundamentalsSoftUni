import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem09MostFrequentWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s*\\W\\s*");
        TreeMap<String, Integer> words = new TreeMap<>();
        for (String s : input) {
            String currentWord = s.toLowerCase();
            if (!words.containsKey(currentWord)) {
                words.put(currentWord, 1);
            } else {
                words.put(currentWord, words.get(currentWord) + 1);
            }
        }

        int max = 0;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() > max){
                max = entry.getValue();
            }
        }

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == max){
                System.out.printf("%s -> %d times", entry.getKey(), entry.getValue());
                System.out.println();
            }
        }
    }
}
