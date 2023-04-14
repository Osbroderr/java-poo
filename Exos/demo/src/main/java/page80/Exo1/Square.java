package page80.Exo1;

public class Square extends Rectangle {
    public Square(int cote) {
        super(cote, cote);
    }

    public int getSurface() {
        return getLargeur() * getHauteur();
    }
}
