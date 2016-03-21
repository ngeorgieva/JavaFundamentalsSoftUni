package com.company;

import java.util.Scanner;

public class SumNumbersFrom1ToN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer number = Integer.parseInt(sc.nextLine());

        Integer result = 0;
        for (int i = 1; i <= number; i++) {
            result += i;
        }

        System.out.println(result);
    }
}
