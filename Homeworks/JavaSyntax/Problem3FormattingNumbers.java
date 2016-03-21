import java.util.Scanner;

public class Problem3FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        String aToHex = Integer.toHexString(a).toUpperCase();
        String aToBin = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", aToHex, aToBin, b, c);
    }
}
