import java.util.Scanner;

public class Problem5ConvertFromDecimalSystemToBase7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(Integer.toString(number, 7));
    }
}
