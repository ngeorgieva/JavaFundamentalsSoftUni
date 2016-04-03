import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("\\|[\\w\\s*'*.*,*]*\\|");
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();
        result.append(text);

        while (matcher.find()) {
            char[] bomb = matcher.group().substring(1, matcher.group().length() - 1).toCharArray();
            int sumOfChars = 0;
            for (char c : bomb) {
                sumOfChars += (int) c;
            }

            int bombPower = sumOfChars % 10;
            int bombStartIndex = text.indexOf('|');
            int bombEndIndex = bombStartIndex + bomb.length + 2;
            int startIndex = Math.max(0, bombStartIndex - bombPower);
            int endIndex = Math.min(text.length(), bombEndIndex + bombPower);
            for (int i = startIndex; i < endIndex; i++) {
                result.setCharAt(i, '.');
            }

            text = result.toString();
        }

        System.out.println(text);
    }
}