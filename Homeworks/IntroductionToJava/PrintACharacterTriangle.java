package com.company;

import java.util.Scanner;

public class PrintACharacterTriangle {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer input = Integer.parseInt(console.nextLine());

        for (int i = 1; i <= input; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((char)(j + 97) + " ");
            }

            System.out.println();
        }

        for (int i = input - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((char)(j + 97) + " ");
            }

            System.out.println();
        }
    }
}
