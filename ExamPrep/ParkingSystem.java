import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        boolean[][] parkingLot = new boolean[rows][cols];

        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String[] coordinates = input.split(" ");
            int entryRow = Integer.parseInt(coordinates[0]);
            int desiredRow = Integer.parseInt(coordinates[1]);
            int desiredCol = Integer.parseInt(coordinates[2]);
            int movesCount = 1;
            if (!parkingLot[desiredRow][desiredCol]) {
                parkingLot[desiredRow][desiredCol] = true;
                movesCount += Math.abs(desiredRow - entryRow) + desiredCol;
                System.out.println(movesCount);
            } else if (parkingLot[desiredRow][desiredCol]) {
                boolean[] wantedRow = parkingLot[desiredRow];
                int newCol = getTheClosestFreeSpot(wantedRow, desiredCol);
                if (newCol == -1) {
                    System.out.println(String.format("Row %d full", desiredRow));
                } else {
                    parkingLot[desiredRow][newCol] = true;
                    movesCount += Math.abs(desiredRow - entryRow) + newCol;
                    System.out.println(movesCount);
                }
            }

            input = scan.nextLine();
        }
    }

    private static int getTheClosestFreeSpot(boolean[] desiredRow, int desiredCol) {
        if (desiredCol == 1) {
            for (int i = 2; i < desiredRow.length; i++) {
                if (!desiredRow[i]) {
                    return i;
                }
            }
        } else if (desiredCol == desiredRow.length - 1) {
            for (int i = desiredRow.length - 2; i >= 1; i--) {
                if (!desiredRow[i]) {
                    return i;
                }
            }
        } else {
            int n = Math.max((desiredRow.length - 1 - desiredCol), desiredRow.length - 1);
            for (int i = 1; i <= n; i++) {
                if (desiredCol - i >= 1) {
                    if (desiredRow[desiredCol - i] == false) {
                        return desiredCol - i;
                    }
                    if (desiredCol + i <= desiredRow.length - 1) {
                        if (!desiredRow[desiredCol + i]) {
                            return desiredCol + i;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

