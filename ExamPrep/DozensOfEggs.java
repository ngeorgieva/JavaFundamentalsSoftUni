import java.util.Scanner;

public class DozensOfEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggsCount = 0;
        int dozensCount = 0;
        for (int i = 0; i < 7; i++) {
            String[] input = scan.nextLine().split(" ");
            int count = Integer.parseInt(input[0]);
            String measure = input[1];
            switch (measure){
                case "eggs":
                    eggsCount += count;
                    break;
                case "dozens":
                    dozensCount += count;
                    break;
            }
        }

        if (eggsCount >= 12){
            dozensCount += eggsCount / 12;
            eggsCount = eggsCount % 12;
        }

        System.out.printf("%d dozens + %d eggs", dozensCount, eggsCount);
    }
}
