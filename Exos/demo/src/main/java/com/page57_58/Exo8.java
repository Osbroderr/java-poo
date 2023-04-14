package com.page57_58;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le chemin du fichier : ");
        String cheminFichier = scanner.nextLine();

        try {
            File fichier = new File(cheminFichier);
            Scanner lecteur = new Scanner(fichier);

            int nombreMots = 0;

            while (lecteur.hasNext()) {
                lecteur.next();
                nombreMots++;
            }

            lecteur.close();

            System.out.println("Le fichier " + cheminFichier + " contient " + nombreMots + " mots.");

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier " + cheminFichier + " n'existe pas.");
        }
    }
}
