package com.page57_58;

import java.util.Random;
import java.util.Scanner;

public class Exo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int nombreATrouver = random.nextInt(100) + 1;
        int nombreEssais = 0;

        System.out.println("Je pense à un nombre entre 1 et 100. Devinez le nombre !");

        int nombrePropose;
        do {
            System.out.print("Votre proposition : ");
            nombrePropose = scanner.nextInt();
            nombreEssais++;

            if (nombrePropose < nombreATrouver) {
                System.out.println("Le nombre à trouver est plus grand.");
            } else if (nombrePropose > nombreATrouver) {
                System.out.println("Le nombre à trouver est plus petit.");
            }
        } while (nombrePropose != nombreATrouver);

        System.out.println("Bravo, vous avez trouvé le nombre en " + nombreEssais + " coups !");
    }
}
