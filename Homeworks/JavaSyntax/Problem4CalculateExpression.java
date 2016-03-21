import java.util.Scanner;

public class Problem4CalculateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        double f1Result = Math.pow(((a * a + b * b) / (a * a - b * b)), (a + b + c) / Math.sqrt(c));
        double f2Result = Math.pow((a * a + b * b - c * c * c), (a - b));
        double f3Result = Math.abs((getAverage(new double[] {a, b, c})) - (getAverage(new double[] {f1Result, f2Result})));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1Result, f2Result, f3Result);
    }

    private static double getAverage(double[] nums){
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum / nums.length;
    }
}
