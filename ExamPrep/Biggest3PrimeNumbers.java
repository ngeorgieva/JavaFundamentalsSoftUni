import java.util.*;

public class Biggest3PrimeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        String[] input = scan.nextLine().split("[( )]+");
        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals("")) {
                int number = Integer.parseInt(input[i]);
                if (!primeNumbers.contains(number) && isPrime(number)){
                    primeNumbers.add(number);
                }
            }
        }

        Collections.sort(primeNumbers);
        if (primeNumbers.size() < 3){
            System.out.println("No");
        } else {
            System.out.println(primeNumbers.get(primeNumbers.size() - 1) +
                    primeNumbers.get(primeNumbers.size() - 2) +
                    primeNumbers.get(primeNumbers.size() - 3));
        }
    }

    private static boolean isPrime(int number) {
        boolean isPrime = true;
        if (number <= 1){
            isPrime = false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }

        return isPrime;
    }
}
