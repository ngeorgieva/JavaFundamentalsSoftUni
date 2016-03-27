import java.util.*;

public class Problem08ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s*\\W\\s*");
        ArrayList<String> words = new ArrayList<>();
        for (String s : input) {
            if (!words.contains(s.toLowerCase())){
                words.add(s.toLowerCase());
            }
        }

        Collections.sort(words);
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
