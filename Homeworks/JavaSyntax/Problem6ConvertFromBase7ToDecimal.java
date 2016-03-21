import java.util.Scanner;

public class Problem6ConvertFromBase7ToDecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(convertFromBase7ToBase10(number));
    }

    private static long convertFromBase7ToBase10(int num){
        char[] numAsStr = Integer.toString(num).toCharArray();
        long result = 0L;
        int currentIndex = numAsStr.length - 1;

        for (int i = 0; i < numAsStr.length; i++) {
            int currentDigit = Integer.parseInt(Character.toString(numAsStr[i]));
            result += currentDigit * Math.pow(7, currentIndex);
            currentIndex--;
        }

        return result;
    }
}
