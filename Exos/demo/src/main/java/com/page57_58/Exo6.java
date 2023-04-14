package com.page57_58;

import java.util.Scanner;

public class Exo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez une phrase : ");
        String phrase = scanner.nextLine();

        int nombreMots = 0;
        boolean motEnCours = false;

        for (char c : phrase.toCharArray()) {
            if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                if (motEnCours) {
                    nombreMots++;
                    motEnCours = false;
                }
            } else {
                motEnCours = true;
            }
        }

        if (motEnCours) {
            nombreMots++;
        }

        System.out.println("Il y a " + nombreMots + " mots dans la phrase.");
    }
}
