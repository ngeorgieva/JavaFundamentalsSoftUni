import org.omg.CORBA.Environment;

import java.util.Scanner;

public class Problem9HitTheTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target){
                    System.out.printf("%d + %d = %d", i, j, target);
                    System.out.println();
                }else if (j - i == target){
                    System.out.printf("%d - %d = %d", j, i, target);
                    System.out.println();
                }
            }
        }
    }
}
