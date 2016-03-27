import java.util.Scanner;

public class Problem06CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s*\\W\\s*");
        String targetWord = scan.nextLine();
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].toLowerCase().equals(targetWord)){
                count++;
            }
        }

        System.out.println(count);
    }
}
