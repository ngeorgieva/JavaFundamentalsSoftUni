import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem10CardsFrequencies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        LinkedHashMap<String, Integer> cards = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String currentCard = input[i].substring(0, input[i].length() - 1);
            if (!cards.containsKey(currentCard)){
                cards.put(currentCard, 1);
            } else {
                cards.put(currentCard, cards.get(currentCard) + 1);
            }
        }

        for (Map.Entry<String, Integer> card : cards.entrySet()) {
            System.out.printf("%s -> %.2f", card.getKey(), (card.getValue() / (double)input.length) * 100.0);
            System.out.print("%");
            System.out.println();
        }
    }
}
