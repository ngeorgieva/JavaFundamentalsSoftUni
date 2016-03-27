import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        TreeMap<String, TreeMap<String, Integer>> log = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String user = input[1];
            String ipAddress = input[0];
            int duration = Integer.parseInt(input[2]);

            if (!log.containsKey(user)){
                log.put(user, new TreeMap<>());
                log.get(user).put(ipAddress, duration);
            } else if(!log.get(user).containsKey(ipAddress)) {
                log.get(user).put(ipAddress, duration);
            } else {
                log.get(user).put(ipAddress, log.get(user).get(ipAddress) + duration);
            }
        }

        for (String s : log.keySet()) {
            System.out.printf("%s: ", s);
            Map<String, Integer> values = new TreeMap<>(log.get(s));
            ArrayList<String> addresses = new ArrayList<>();
            int duration = 0;
            for (Map.Entry<String, Integer> pair : values.entrySet()) {
                addresses.add(pair.getKey());
                duration += pair.getValue();
            }

            System.out.printf("%d ", duration);
            System.out.println(addresses);
        }
    }
}
