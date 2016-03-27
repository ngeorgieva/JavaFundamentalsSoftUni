import java.util.Scanner;

public class Problem11ImplementRecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        scan.nextLine();
        String[] input = scan.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(recursiveBinarySearch(numbers, 0, numbers.length, target));
    }

    private static int recursiveBinarySearch(int[] array, int startIndex, int endIndex, int target){
        int resultIndex = -1;
        if (startIndex < endIndex){
            int mid = (startIndex + endIndex) / 2;
            if (target == array[mid]){
                resultIndex = mid;
            } else if (target < array[mid]){
                resultIndex = recursiveBinarySearch(array, startIndex, mid - 1, target);
            } else if (target > array[mid]){
                resultIndex =  recursiveBinarySearch(array, mid + 1, endIndex, target);
            }

            for (int i = resultIndex; i > 0; i--) {
                if (array[resultIndex - 1] == target){
                    resultIndex -= 1;
                }
           }

            return resultIndex;
        }

        return resultIndex;
    }
}
