import java.util.Scanner;

public class Problem8OddOrEvenPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] numbersAsStr = input.split(" ");
        int[] numbers = new int[numbersAsStr.length];
        for (int i = 0; i < numbersAsStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStr[i]);
        }

        if (numbers.length % 2 == 0) {
            for (int i = 1; i < numbers.length; i+=2) {
                if (numbers[i] % 2 == 0 && numbers[i - 1] % 2 == 0) {
                    System.out.printf("%d, %d -> both are even", numbers[i - 1], numbers[i]);
                }else if (numbers[i] % 2 != 0 && numbers[i - 1] % 2 != 0){
                    System.out.printf("%d, %d -> both are odd", numbers[i - 1], numbers[i]);
                } else{
                    System.out.printf("%d, %d -> different", numbers[i - 1], numbers[i]);
                }
                System.out.println();
            }
        }else{
            System.out.println("Invalid length");
        }
    }
}
