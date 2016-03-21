import java.util.ArrayList;
import java.util.Scanner;

public class Problem11GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numbersAsString = scan.nextLine();
        String command = scan.nextLine();
        String[] numbersArr = numbersAsString.split(" ");
        int[] numbers = new int[numbersArr.length];
        for (int i = 0; i < numbersArr.length; i++) {
            numbers[i] = Integer.parseInt(numbersArr[i]);
        }

        String[] commandArgs = command.split(" ");
        int numberOfElements = Integer.parseInt(commandArgs[1]);
        String type = commandArgs[2];
        ArrayList<Integer> result = getFirstOddOrEvenElements(numbers, numberOfElements, type);
        for (int element: result) {
            System.out.print(element + " ");
        }
    }

    private static ArrayList<Integer> getFirstOddOrEvenElements(int[] arr, int numberOfElements, String type) {
        ArrayList<Integer> elementsFound = new ArrayList<Integer>();
        switch (type) {
            case "even":
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 2 == 0) {
                        elementsFound.add(arr[i]);
                        if (elementsFound.size() > numberOfElements){
                            break;
                        }
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 2 != 0) {
                        elementsFound.add(arr[i]);
                        if (elementsFound.size() > numberOfElements){
                            break;
                        }
                    }
                }
                break;
        }
        return elementsFound;
    }
}
