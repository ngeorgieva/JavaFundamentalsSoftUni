import java.util.*;
import java.util.stream.Collectors;

public class ChampionsLeague {
    public static void main(String[] args) {
        TreeMap<String, TreeSet<String>> teams = new TreeMap<>();
        TreeMap<String, Integer> score = new TreeMap<>();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String[] tokens = input.split("(\\s\\|\\s)");
            String team1 = tokens[0];
            String team2 = tokens[1];
            String[] result1 = tokens[2].split(":");
            String[] result2 = tokens[3].split(":");
            int team1Score = Integer.parseInt(result1[0]) + Integer.parseInt(result2[1]);
            int team2Score = Integer.parseInt(result1[1]) + Integer.parseInt(result2[0]);
            String winner = "";
            if (team1Score != team2Score) {
                if (team1Score > team2Score) {
                    winner = team1;
                } else {
                    winner = team2;
                }
            } else {
                if (Integer.parseInt(result1[1]) > Integer.parseInt(result2[1])) {
                    winner = team2;
                } else {
                    winner = team1;
                }
            }
            if (score.containsKey(team1)){
                score.put(team1, score.get(team1));
            } else {
                score.put(team1, 0);
            }
            if (score.containsKey(team2)){
                score.put(team2, score.get(team2));
            } else {
                score.put(team2, 0);
            }
            if (score.containsKey(winner)){
                score.put(winner, score.get(winner) + 1);
            }

            if (!teams.containsKey(team1)){
                teams.put(team1, new TreeSet<>());
                teams.get(team1).add(team2);
            } else {
                teams.get(team1).add(team2);
            }

            if (!teams.containsKey(team2)){
                teams.put(team2, new TreeSet<>());
                teams.get(team2).add(team1);
            } else {
                teams.get(team2).add(team1);
            }

            input = scan.nextLine();
        }

        List<Map.Entry<String, Integer>> sortedScores = score.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> team : sortedScores) {
            sb.append(team.getKey() + "\n");
            sb.append(String.format("- Wins: %d\n", team.getValue()));
            sb.append("- Opponents: ");
            TreeSet<String> opponents = teams.get(team.getKey());
            for (String opponent : opponents) {
                sb.append(opponent + ", ");
            }

            sb.delete(sb.length() - 2, sb.length() - 1);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

