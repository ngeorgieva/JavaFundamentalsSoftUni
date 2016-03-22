import java.util.Scanner;

public class VideoDurations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int totalHours = 0;
        int totalMinutes = 0;
        while(!input.equals("End")){
            String[] duration = input.split(":");
            int hour = Integer.parseInt(duration[0]);
            int minutes = Integer.parseInt(duration[1]);
            totalHours += hour;
            totalMinutes += minutes;
            input = scan.nextLine();
        }

        if (totalMinutes >= 60){
            totalHours += totalMinutes / 60;
            totalMinutes = totalMinutes % 60;
        }

        if (totalMinutes < 10){
            System.out.printf("%d:0%d", totalHours, totalMinutes);
        } else {
        System.out.printf("%d:%d", totalHours, totalMinutes);
        }
    }
}
