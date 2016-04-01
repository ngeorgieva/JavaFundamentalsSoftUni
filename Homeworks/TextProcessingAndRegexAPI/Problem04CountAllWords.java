import java.util.Scanner;

public class Problem04CountAllWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\W+");
        System.out.println(words.length);
    }
}
