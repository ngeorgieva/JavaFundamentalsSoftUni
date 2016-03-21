import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problem7RandomizeNumbersFromNToM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int biggerNum = Math.max(n, m);
        int smallerNum = Math.min(n, m);

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = smallerNum; i <= biggerNum; i++) {
            numbers.add(i);
        }

        while(numbers.size() > 0){
            Random rnd = new Random();
            int index = (rnd.nextInt(numbers.size()));
            System.out.print(numbers.get(index) + " ");
            numbers.remove(index);
        }
    }
}
