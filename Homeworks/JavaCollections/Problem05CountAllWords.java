import java.util.Scanner;

public class Problem05CountAllWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s*[^A-Za-z]\\s*");
        System.out.println(input.length);
    }
}
