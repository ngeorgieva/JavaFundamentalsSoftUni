import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("\\s+", "");
        String pattern = "([-|+]*)(\\d+\\.*\\d*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(input);
        BigDecimal sum = new BigDecimal("0");
        while (matcher.find()){
            String operator = matcher.group(1);
            String number = matcher.group(2);
            if (operator.length() == 0 || operator.equals("+")){
                sum = sum.add(new BigDecimal(number));
            } else if(operator.equals("-")){
                sum = sum.subtract(new BigDecimal(number));
            }
        }

        System.out.println(sum);
    }
}
