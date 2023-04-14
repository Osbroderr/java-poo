package page80.Exo1;

public class Voiture {
    private String marque;
    private String modele;
    private int anneeFabrication;

    public Voiture(String marque, String modele, int anneeFabrication) {
        this.marque = marque;
        this.modele = modele;
        this.anneeFabrication = anneeFabrication;
    }

    public void demarrer() {
        System.out.println("La voiture démarre.");
    }

    public void arreter() {
        System.out.println("La voiture s'arrête.");
    }
}
