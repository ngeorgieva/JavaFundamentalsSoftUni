import java.sql.Time;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        TreeMap<String, TreeMap<String, ArrayList<Time>>> events = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String regex = "^\\s*#([A-Za-z]+):\\s*@([A-Za-z]+)\\s*(\\d{1,2}):(\\d{1,2})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while(matcher.find()){
                Time time;
                String location = matcher.group(2);
                String performer = matcher.group(1);
                int hour = Integer.parseInt(matcher.group(3));
                int minutes = Integer.parseInt(matcher.group(4));
                if (hour > -1 && hour <= 23 && minutes > -1 && minutes <= 59){
                    time = Time.valueOf(String.format("%s:%s:%s", matcher.group(3), matcher.group(4), "00"));
                } else {
                    continue;
                }

                if (!events.containsKey(location)){
                    TreeMap<String, ArrayList<Time>> subMap = new TreeMap<>();
                    subMap.put(performer, new ArrayList<Time>());
                    subMap.get(performer).add(time);
                    events.put(location, subMap);
                } else if (!events.get(location).containsKey(performer)){
                    events.get(location).put(performer, new ArrayList<>());
                    events.get(location).get(performer).add(time);
                } else {
                    events.get(location).get(performer).add(time);
                }
            }
        }

        String[] wantedLocation = scan.nextLine().split(",");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TreeMap<String, ArrayList<Time>>> entry : events.entrySet()) {
            if (Arrays.asList(wantedLocation).contains(entry.getKey())) {
                sb.append(entry.getKey() + ": \n");
                TreeMap<String, ArrayList<Time>> subMap = entry.getValue();
                int index = 1;
                for (Map.Entry<String, ArrayList<Time>> subEntry : subMap.entrySet()) {
                    ArrayList<Time> times = subEntry.getValue();
                    Collections.sort(times);
                    sb.append(String.format("%d. %s -> ", index, subEntry.getKey()));
                    for (Time time : times) {
                        sb.append(String.format("%s, ", time.toString().substring(0, 5)));
                    }

                    index++;
                    sb.delete(sb.length() - 2, sb.length() - 1);
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
