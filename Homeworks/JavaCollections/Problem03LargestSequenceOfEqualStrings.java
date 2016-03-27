import java.util.*;

public class Problem03LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = scan.nextLine().split(" ");
        Map<String, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!occurrences.containsKey(strings[i])){
                occurrences.put(strings[i], 1);
            } else {
                occurrences.put(strings[i], occurrences.get(strings[i]) + 1);
            }
        }

        int max = 0;
        for (String s : occurrences.keySet()) {
            if (occurrences.get(s) > max){
                max = occurrences.get(s);
            }
        }

        for (Map.Entry<String, Integer> entry: occurrences.entrySet()) {
            if (entry.getValue() == max){
                System.out.printf(String.join("", Collections.nCopies(entry.getValue(), entry.getKey() + " ")).trim());
                break;
            }
        }
    }
}
