import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CollectResources {
    public static void main(String[] args) {

        String[] validResources = new String[]{ "stone", "gold", "wood", "food" };
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        
        int n = scan.nextInt();
        scan.nextLine();
        int biggestCount = 0;
        for (int i = 0; i < n; i++) {
            String[] startAndStep = scan.nextLine().split(" ");
            int currentPosition = Integer.parseInt(startAndStep[0]);
            int step = Integer.parseInt(startAndStep[1]);
            int result = 0;
            ArrayList<String> resourceField = new ArrayList<String>();
            for (String item : input) {
                resourceField.add(item);
            }

            while(!resourceField.get(currentPosition).equals("collected")){
                String resource = "";
                int value = 0;
                if (resourceField.get(currentPosition).contains("_")) {
                    String[] elements = resourceField.get(currentPosition).split("_");
                    resource = elements[0];
                    value = Integer.parseInt(elements[1]);
                } else {
                    resource = resourceField.get(currentPosition);
                    value = 1;
                }
                if (Arrays.asList(validResources).contains(resource)){
                    result += value;
                    resourceField.set(currentPosition, "collected");
                    currentPosition = getPositionOfNextElement(currentPosition, step, resourceField);
                } else {
                    currentPosition = getPositionOfNextElement(currentPosition, step, resourceField);
                }

                if (result > biggestCount){
                    biggestCount = result;
                }
            }
        }

        System.out.println(biggestCount);
    }

    private static int getPositionOfNextElement(int currentIndex, int step, ArrayList<String> resourceField){
        step = step % resourceField.size();
        currentIndex += step;
        int positionToChange = currentIndex % resourceField.size();
        if (positionToChange < 0) {
            positionToChange += resourceField.size();
        } else if (positionToChange >= resourceField.size())
        {
            positionToChange -= resourceField.size();
        }

        return positionToChange;
    }
}
