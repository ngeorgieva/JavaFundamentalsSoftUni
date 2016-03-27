import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem07CombineListOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        ArrayList<Character> l1 = convertStringIntoCharList(input1);
        String input2 = scan.nextLine();
        ArrayList<Character> l2 = convertStringIntoCharList(input2);

        for (int i = 0; i < l1.size(); i++) {
            Character currentChar = l1.get(i);
            if (l2.contains(currentChar)){
                l2.removeAll(Collections.singleton(currentChar));
            }
        }

        for (Character character : l1) {
            System.out.print(character + " ");
        }

        for (Character character : l2) {
            System.out.print(character + " ");
        }
    }

    private static ArrayList<Character> convertStringIntoCharList(String input) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (!currentChar.equals(' ')) {
                list.add(input.charAt(i));
            }
        }
        return list;
    }
}
