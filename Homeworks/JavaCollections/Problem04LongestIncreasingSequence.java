import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem04LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = scan.nextLine().split(" ");
        int[] numbers = new int[strings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        List<Integer> maxSequence = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(numbers[i]);

            while(i < numbers.length - 1 && numbers[i + 1] > numbers[i]){
                temp.add(numbers[i + 1]);
                i++;
            }

            System.out.println(temp.toString().replace("[", "").replace("]", "").replace(",", ""));

            if (temp.size() > maxSequence.size()){
                maxSequence.clear();
                maxSequence.addAll(temp);
            }
        }

        System.out.printf("Longest: " + maxSequence.toString().replace("[", "").replace("]", "").replace(",", ""));
    }
}
