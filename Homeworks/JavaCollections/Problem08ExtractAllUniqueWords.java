import java.util.*;

public class Problem08ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s*\\W\\s*");
        TreeSet<String> words = new TreeSet<>();
        for (String s : input) {
            if (!words.contains(s.toLowerCase())){
                words.add(s.toLowerCase());
            }
        }

        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
