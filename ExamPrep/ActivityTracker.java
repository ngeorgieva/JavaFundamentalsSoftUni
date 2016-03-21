import java.util.*;

public class ActivityTracker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        HashMap<Integer, HashMap<String, Integer>> activityTracker = new HashMap<Integer, HashMap<String, Integer>>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] details = input.split(" ");
            int month = Integer.parseInt(details[0].substring(3, 5));
            String name = details[1];
            int distance = Integer.parseInt(details[2]);
            if (!activityTracker.containsKey(month)){
                activityTracker.put(month, new HashMap<String, Integer>());
                activityTracker.get(month).put(name, distance);
            } else {
                if (!activityTracker.get(month).containsKey(name)){
                    activityTracker.get(month).put(name, distance);
                } else {
                    activityTracker.get(month).put(name, activityTracker.get(month).get(name) + distance);
                }
            }
        }

        for (Integer month: activityTracker.keySet()) {
            System.out.printf("%d: ", month);
            Map<String, Integer> value = new TreeMap<>(activityTracker.get(month));
            String result = "";
            for (String name: value.keySet()) {
                result += name.toString() + "(" + value.get(name) + ")" + ", ";
            }
            System.out.println(result.substring(0, result.length() - 2));
        }
    }
}
