package com.page57_58;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez une phrase : ");
        String phrase = scanner.nextLine();

        System.out.print("Entrez le nom du fichier : ");
        String nomFichier = scanner.nextLine();

        try {
            File fichier = new File(nomFichier + ".txt");
            FileWriter writer = new FileWriter(fichier);
            writer.write(phrase);
            writer.close();
            System.out.println("La phrase a été enregistrée dans le fichier " + nomFichier + ".txt");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }
}
