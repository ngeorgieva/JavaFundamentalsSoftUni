import java.util.Scanner;

public class Monopoly {
    public static int money = 50;
    public static int hotelsBought = 0;
    public static int turns = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        char[][] gameField = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            gameField[i] = scan.nextLine().toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < cols; col++) {
                    processTurn(gameField[row][col], row, col);
                    if (hotelsBought > 0) {
                        money += hotelsBought * 10;
                    }
                    turns++;
                }
            } else {
                for (int col = cols - 1; col >= 0; col--) {
                    processTurn(gameField[row][col], row, col);
                    if (hotelsBought > 0) {
                        money += hotelsBought * 10;
                    }
                    turns++;
                }
            }
        }

        System.out.printf("Turns %d\n", turns);
        System.out.printf("Money %d\n", money);
    }

    private static void processTurn(char c, int currentRow, int currentCol) {
        switch (c) {
            case 'H':
                hotelsBought++;
                System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, hotelsBought);
                money -= money;
                break;
            case 'J':
                System.out.printf("Gone to jail at turn %d.\n", turns);
                turns += 2;
                money += 2 * (hotelsBought * 10);
                break;
            case 'F':
                break;
            case 'S':
                int moneySpentAtTheShop = (currentRow + 1) * (currentCol + 1);
                if (moneySpentAtTheShop > money) {
                    moneySpentAtTheShop = money;
                }
                System.out.printf("Spent %d money at the shop.\n", moneySpentAtTheShop);
                money -= moneySpentAtTheShop;
                break;
        }
    }
}
