import java.util.Scanner;

public class SumCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int sum = 0;
        int duplicateNumsSum = 0;
        if (input.length == 1){
            sum += getCardValue(input[0]);
        } else {
            int firstElement = getCardValue(input[0]);
            int secondElement = getCardValue(input[1]);
            if (firstElement == secondElement) {
                duplicateNumsSum += firstElement;
            } else {
                sum += firstElement;
            }

            for (int i = 1; i < input.length; i++) {
                int value = getCardValue(input[i]);
                if (value == getCardValue(input[i - 1]) || (i != input.length - 1 && value == getCardValue(input[i + 1]))) {
                    duplicateNumsSum += value;
                } else {
                    sum += value;
                }
            }
        }
        sum += duplicateNumsSum * 2;
        System.out.println(sum);
    }

    private static int getCardValue(String input) {
        String face = input.substring(0, input.length() - 1);
        int value;
        switch (face){
            case "J":
                value = 12;
                break;
            case "Q":
                value = 13;
                break;
            case "K":
                value = 14;
                break;
            case "A":
                value = 15;
                break;
            default:
                value = Integer.parseInt(face);
                break;
        }
        return value;
    }
}
