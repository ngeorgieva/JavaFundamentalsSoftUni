import java.util.Scanner;

public class Problem10CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] strings = input.split(" ");
        System.out.println(multiplyCharacters(strings));
    }
    private static long multiplyCharacters(String[] strings){
        String longerStr = "";
        String shorterStr = "";
        long result = 0;
        if (strings[0].length() == strings[1].length()){
            for (int i = 0; i < strings[0].length(); i++) {
                result += (int)strings[0].charAt(i) * (int)strings[1].charAt(i);
            }
            return result;
        } else if (strings[0].length() > strings[1].length()){
            longerStr = strings[0];
            shorterStr = strings[1];
        } else if(strings[0].length() < strings[1].length()) {
            longerStr = strings[1];
            shorterStr = strings[0];
        }

        for (int i = 0; i < shorterStr.length(); i++) {
                result += (int)longerStr.charAt(i) * (int)shorterStr.charAt(i);
            }
        int index = longerStr.length() - (longerStr.length() - shorterStr.length());
        for (int i = index; i < longerStr.length(); i++) {
            result += (int)longerStr.charAt(i);
        }

        return result;
    }
}
