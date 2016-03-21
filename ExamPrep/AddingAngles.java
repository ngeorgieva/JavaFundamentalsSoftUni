import java.util.Scanner;

public class AddingAngles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }

        if (n < 3){
            System.out.println("No");
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((numbers[i] + numbers[j] + numbers[k]) % 360 == 0) {
                        System.out.printf("%d + %d + %d = %d degrees",
                                numbers[i],
                                numbers[j],
                                numbers[k],
                                numbers[i] + numbers[j] + numbers[k]);
                        System.out.println();
                        count++;
                    }
                }
            }
        }
        if (count == 0){
            System.out.println("No");
        }
    }
}
