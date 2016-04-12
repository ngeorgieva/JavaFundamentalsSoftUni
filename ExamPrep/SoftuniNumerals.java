import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniNumerals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numeral = scan.nextLine();
        Pattern pattern = Pattern.compile("aa|aba|bcc|cc|cdc");
        Matcher matcher = pattern.matcher(numeral);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            switch (matcher.group()) {
                case "aa":
                    sb.append("0");
                    break;
                case "aba":
                    sb.append("1");
                    break;
                case "bcc":
                    sb.append("2");
                    break;
                case "cc":
                    sb.append("3");
                    break;
                case "cdc":
                    sb.append("4");
                    break;
            }
        }

        char[] sUNum = sb.toString().toCharArray();
        BigInteger result = new BigInteger("0");

        int power = sUNum.length - 1;
        for (int i = 0; i < sUNum.length; i++)
        {
            result = result.add((new BigInteger(String.valueOf(sUNum[i])).multiply(new BigInteger("5").pow(power))));

            power--;
        }

        System.out.println(result);
    }
}
