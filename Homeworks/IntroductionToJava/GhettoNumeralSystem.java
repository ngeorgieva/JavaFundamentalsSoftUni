package com.company;

import java.util.Scanner;

public class GhettoNumeralSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        String result = "";
        for (char c : number.toCharArray()) {
            switch (c){
                case '0':
                    result += "Gee";
                    break;
                case '1':
                    result += "Bro";
                    break;
                case '2':
                    result += "Zuz";
                    break;
                case '3':
                    result += "Ma";
                    break;
                case '4':
                    result += "Duh";
                    break;
                case '5':
                    result += "Yo";
                    break;
                case '6':
                    result += "Dis";
                    break;
                case '7':
                    result += "Hood";
                    break;
                case '8':
                    result += "Jam";
                    break;
                case '9':
                    result += "Mack";
                    break;
            }
        }

        System.out.println(result);
    }
}
