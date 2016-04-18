import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RubiksMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimentions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);
        int[][] originalMatrix = fillMatrix(rows, cols);

        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");
            int rowOrCol = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int moves = Integer.parseInt(tokens[2]);
            ArrayList<Integer> toManipulate = new ArrayList<>();
            switch (direction){
                case "up":
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            if (col == rowOrCol) {
                                toManipulate.add(originalMatrix[row][col]);
                            }
                        }
                    }
                    Collections.rotate(toManipulate, -moves);
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            if (col == rowOrCol){
                                originalMatrix[row][col] = toManipulate.get(row);
                            }
                        }
                    }
                    break;
                case "down":
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            if (col == rowOrCol) {
                                toManipulate.add(originalMatrix[row][col]);
                            }
                        }
                    }
                    Collections.rotate(toManipulate, moves);
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            if (col == rowOrCol){
                                originalMatrix[row][col] = toManipulate.get(row);
                            }
                        }
                    }
                    break;
                case "left":
                    for (int num : originalMatrix[rowOrCol]) {
                        toManipulate.add(num);
                    }
                    Collections.rotate(toManipulate, -moves);
                    for (int col = 0; col < originalMatrix[rowOrCol].length; col++) {
                        originalMatrix[rowOrCol][col] = toManipulate.get(col);
                    }
                    break;
                case "right":
                    for (int num : originalMatrix[rowOrCol]) {
                        toManipulate.add(num);
                    }
                    Collections.rotate(toManipulate, moves);
                    for (int col = 0; col < originalMatrix[rowOrCol].length; col++) {
                        originalMatrix[rowOrCol][col] = toManipulate.get(col);
                    }
                    break;
            }
        }

        int[][] orderedMatrix = fillMatrix(rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (originalMatrix[row][col] != orderedMatrix[row][col]){
                    String swap = getShufflePosition(originalMatrix, orderedMatrix[row][col]);
                    int temp = originalMatrix[row][col];
                    originalMatrix[row][col] = orderedMatrix[row][col];
                    int row1 = Integer.parseInt(swap.split(", ")[0]);
                    int col1 = Integer.parseInt(swap.split(", ")[1]);
                    originalMatrix[row1][col1] = temp;
                    System.out.printf("Swap (%d, %d) with (%s)\n", row, col, swap);
                } else {
                    System.out.println("No swap required");
                }
            }
        }
    }

    private static int[][] fillMatrix(int rows, int cols){
        int[][] matrix = new int[rows][];
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix[row] = new int[cols];
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = number;
                number++;
            }
        }

        return matrix;
    }

    private static String getShufflePosition(int[][] matrix, int element){
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == element){
                    sb.append(String.format("%d, %d", row, col));
                }
            }
        }

        return sb.toString();
    }
}
