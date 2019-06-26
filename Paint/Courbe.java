import java.awt.*;
import java.util.ArrayList;

public class Courbe implements Tracable{
    ArrayList<Point> points;
    private Color couleur;
    

    public Courbe(Color c) {
        this.couleur = c;
        points = new ArrayList<Point>();
    }
}