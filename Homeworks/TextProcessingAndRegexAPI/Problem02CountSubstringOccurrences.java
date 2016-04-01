import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine().toLowerCase();
        String targetString = scan.nextLine().toLowerCase();
        String regex = String.format("(?=(%s))", targetString);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while(matcher.find()){
            count++;
        }
        System.out.println(count);
    }
}
