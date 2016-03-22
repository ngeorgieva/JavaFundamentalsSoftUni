import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CouplesFrequency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        LinkedHashMap<String, Integer> couples = new LinkedHashMap<>();
        for (int i = 1; i < input.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(input[i - 1]);
            sb.append(" ");
            sb.append(input[i]);
            if (!couples.containsKey(sb.toString())){
                couples.put(sb.toString(), 1);
            } else {
                int oldCount = couples.get(sb.toString());
                couples.put(sb.toString(), oldCount + 1);
            }
        }

        for (Map.Entry<String, Integer> couple : couples.entrySet()) {
            int couplesCount = input.length - 1;
            double frequency = 100.0 / couplesCount;
            System.out.printf("%s -> %.2f", couple.getKey(), couple.getValue() * frequency);
            System.out.println("%");
        }

    }
}
