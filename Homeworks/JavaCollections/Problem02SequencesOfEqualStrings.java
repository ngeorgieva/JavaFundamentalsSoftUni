import java.util.Scanner;

public class Problem02SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        System.out.print(line[0]);
        for (int i = 1; i < line.length; i++) {
            if (line[i].equals(line[i - 1])){
                System.out.print(" " + line[i]);
            } else {
                System.out.printf("%n%s", line[i]);
            }
        }
    }
}
