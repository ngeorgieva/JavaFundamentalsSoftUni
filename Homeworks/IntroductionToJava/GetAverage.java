package com.company;

import java.util.Scanner;

public class GetAverage {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbersAsStr = input.split(" ");
        Double[] numbers = new Double[numbersAsStr.length];
        for (int i = 0; i < numbersAsStr.length; i++) {
            numbers[i] = Double.parseDouble(numbersAsStr[i]);
        }

        double avg = getAverage(numbers);
        System.out.printf("%.2f", avg);
    }

    private static double getAverage(Double[] numbers) {
        double sum = 0d;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double avg = sum / numbers.length;
        return avg;
    }
}
