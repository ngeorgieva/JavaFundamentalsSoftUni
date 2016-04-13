import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        ArrayList<String> sortedNumbers = new ArrayList<>();
        for (String s : input) {
            if (s.length() <= 1) {
                int number = Integer.parseInt(s);
                sortedNumbers.add(convertNumberToWord(number));
            } else {
                String[] nums = new String[s.length()];
                for (int i = 0; i < s.toCharArray().length; i++) {
                    nums[i] = String.valueOf(s.toCharArray()[i]);
                }
                StringBuilder finalNumber = new StringBuilder();
                for (int i = 0; i < nums.length; i++) {
                    int number = Integer.parseInt(nums[i]);
                    String num = convertNumberToWord(number);
                    if (i == 0) {
                        finalNumber.append(num);
                    } else {
                        finalNumber.append("-" + num);
                    }
                }

                sortedNumbers.add(finalNumber.toString());
            }
        }

        Collections.sort(sortedNumbers);

        for (int i = 0; i < sortedNumbers.size(); i++) {
            if (!sortedNumbers.get(i).contains("-")) {
                if (i == 0){
                    System.out.print(convertWordToNumber(sortedNumbers.get(i)));
                } else {
                    System.out.print(", " + convertWordToNumber(sortedNumbers.get(i)));
                }
            } else {
                String[] number = sortedNumbers.get(i).split("-");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < number.length; j++) {
                    sb.append(convertWordToNumber(number[j]));
                }

                if (i == 0){
                    System.out.print((sb.toString()));
                } else {
                    System.out.print(", " + sb.toString());
                }
            }
        }
    }

    private static String convertNumberToWord(int num) {
        switch (num) {
            case 0: return "zero";
            case 1: return "one";
            case 2:  return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    private static int convertWordToNumber(String num) {
        switch (num) {
            case "zero": return 0;
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return 0;
        }
    }
}
