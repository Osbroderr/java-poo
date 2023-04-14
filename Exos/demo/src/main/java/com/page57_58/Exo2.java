package com.page57_58;

public class Exo2 {
    public static void main(String args[]) {
        int lines = 10;
        String caratere = "#";
        for (int i = 1; i <= lines; i++) {

            for (int j = 1; j <= lines - i; j++) {
                System.out.print("   ");
            }

            for (int left = 1; left <= i; left++) {
                System.out.print(" " + caratere + " ");
            }

            for (int right = i - 1; right >= 1; right--) {
                System.out.print(" " + caratere + " ");
            }

            System.out.println();
        }

    }

}
