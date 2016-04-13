import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkupLanguage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<String> result = new ArrayList<>();

        while (!input.equals("<stop/>")){
            String regex = "(inverse|reverse|repeat\\s*value\\s*=\\s*\"(\\d+)\")\\s*content\\s*=\\s*\"(.+)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                if (matcher.group(1).contains("inverse")) {
                    for (char c : matcher.group(3).toCharArray()) {
                        if (Character.isUpperCase(c)) {
                            sb.append(Character.toLowerCase(c));
                        } else {
                            sb.append(Character.toUpperCase(c));
                        }
                    }

                    result.add(sb.toString());
                } else if (matcher.group(1).contains("reverse")) {
                    result.add(new StringBuilder(matcher.group(3)).reverse().toString());
                } else {
                    for (int i = 0; i < Integer.parseInt(matcher.group(2)); i++) {
                        result.add(matcher.group(3));
                    }
                }
            }

            input = scan.nextLine();
        }

        for (int i = 1; i <= result.size(); i++) {
            System.out.printf("%d. %s\n", i, result.get(i - 1));
        }
    }
}
