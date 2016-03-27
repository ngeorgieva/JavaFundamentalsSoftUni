import java.util.Arrays;
import java.util.Scanner;

public class Problem01SortArrayOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        scan.nextLine();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }

        Arrays.sort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
