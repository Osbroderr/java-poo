package com.page57_58;

import java.util.Scanner;

public class Exo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer un nombre entier : ");
        int number = Integer.parseInt(scanner.nextLine());

        if (number % 2 == 0) {
            System.out.println(number + " est pair.");
        } else {
            System.out.println(number + " est impair.");
        }

        boolean isPrime = true;
        if (number < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " est premier.");
        } else {
            System.out.println(number + " n'est pas premier.");
        }
    }
}
