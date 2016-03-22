import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LargestThreeRectangles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> areas = new ArrayList<>();
        String input = scan.nextLine();
        String pattern = "(\\d+)\\s*x\\s*(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(input);
        while (matcher.find()){
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(2));
            areas.add(a * b);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 2; i < areas.size(); i++) {
            int area = areas.get(i - 2) + areas.get(i - 1) + areas.get(i);
            if (area > max){
                max = area;
            }
        }

        System.out.println(max);
    }
}
