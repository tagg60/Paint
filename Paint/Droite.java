import java.awt.*;
import java.util.ArrayList;

public interface Tracable{
   public void dessine(Graphics g);
}
public class Droite implements Tracable{
    private Color couleur;
    int x1, x2, y1, y2;

    public Droite(){
        
    }

    public Droite(Color c) {
        this.couleur = c;
    }

    public Droite(int x1, int y1, int x2, int y2, Color c) {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.couleur = c;
    }

    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        g.drawLine(x1, y1, x2, y2);
        
    }
}