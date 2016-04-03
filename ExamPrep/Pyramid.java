
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int number = scan.nextInt();
        scan.nextLine();

        ArrayList<Integer> result = new ArrayList<>();
        result.add(number);
        for (int i = 1; i < n; i++) {
            String line = scan.nextLine().trim();
            String[] numsAsStrings = line.split("\\s+");
            int[] numbers = new int[numsAsStrings.length];
            for (int j = 0; j < numsAsStrings.length; j++) {
                numbers[j] = Integer.parseInt(numsAsStrings[j]);
            }

            Arrays.sort(numbers);
            boolean numberFound = false;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] > number) {
                    result.add(numbers[j]);
                    number = numbers[j];
                    numberFound = true;
                    break;
                }
            }

            if (!numberFound){
                number++;
            }
        }

        System.out.println(result.toString().substring(1, result.toString().length() - 1));
    }
}
