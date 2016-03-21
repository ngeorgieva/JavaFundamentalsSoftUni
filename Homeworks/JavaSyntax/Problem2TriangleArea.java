import java.util.Scanner;

public class Problem2TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int aX = scan.nextInt();
        int aY = scan.nextInt();
        int bX = scan.nextInt();
        int bY = scan.nextInt();
        int cX = scan.nextInt();
        int cY = scan.nextInt();
        int area = calculateTriangleArea(aX, aY, bX, bY, cX, cY);
        System.out.println(area);
    }

    private static int calculateTriangleArea(int aX, int aY, int bX, int bY, int cX, int cY){
        int area = Math.abs(((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2));
        return area;
    }
}
