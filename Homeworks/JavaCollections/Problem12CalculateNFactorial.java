import java.util.Scanner;

public class Problem12CalculateNFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(calculateFactorial(n));
    }
    private static int calculateFactorial(int n){
        if (n <= 1){
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }
}
