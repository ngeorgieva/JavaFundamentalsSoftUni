import java.util.Scanner;

public class Problem1RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int area = calculateRectangleArea(a, b);
        System.out.println(area);
    }

    private static int calculateRectangleArea(int a, int b){
        int area = a * b;
        return area;
    }
}
