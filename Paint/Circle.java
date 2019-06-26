import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Tracable{
   private int x;
   private int y;
   private Color c;
   private boolean plein;
   private int rayon;

   public Circle(){

   }
   
   public Circle(int x, int y, int rayon, boolean plein, Color c) {
      this.x = x;
      this.y = y;
      this.rayon = rayon;
      this.plein = plein;
      this.c = c;
   }

   public void dessine(Graphics g) {
      g.setColor(this.c);
      if (this.plein) {
         g.fillOval(this.x, this.y, this.rayon, this.rayon);
      } else {
         g.drawOval(this.x, this.y, this.rayon, this.rayon);
      }
   }
}