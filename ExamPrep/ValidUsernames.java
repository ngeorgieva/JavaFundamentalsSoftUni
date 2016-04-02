import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        List<String> usernames = getAllValidUsernames(text);
        int longestSum = 0;
        String[] longestUsernames = new String[2];
        for (int i = 0; i < usernames.size() - 1; i++) {
            int lengthSum = usernames.get(i).length() + usernames.get(i + 1).length();
            if (lengthSum > longestSum){
                longestSum = lengthSum;
                longestUsernames[0] = usernames.get(i);
                longestUsernames[1] = usernames.get(i + 1);
            }
        }

        System.out.println(longestUsernames[0]);
        System.out.println(longestUsernames[1]);
    }

    private static List<String> getAllValidUsernames(String text) {
        String regex = "([\\\\\\/\\(\\)\\s])*(\\b([A-Za-z]\\w{2,24})\\b)([\\\\\\/\\(\\)\\s])*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> usernames = new ArrayList<>();

        while(matcher.find()){
            usernames.add(matcher.group(2));
        }

        return usernames;
    }
}
