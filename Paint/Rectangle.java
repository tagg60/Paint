import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Tracable{
    private int x;
    private int y;
    private Color c;
    private int largeur;
    private int longueur;
    private boolean plein;

    public Rectangle(){
        
    }

    public Rectangle(int x, int y, int longueur, int largeur, Color c, boolean plein) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.largeur = largeur;
        this.c = c;
        this.plein = plein;
    }

    public void dessine(Graphics g) {
        g.setColor(this.c);
        if (this.plein) {
            g.fillRect(this.x, this.y, this.longueur, this.largeur);
        } 
        else {
            g.drawRect(this.x, this.y, this.longueur, this.largeur);
        }
    }
}