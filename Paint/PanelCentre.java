import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PanelCentre extends JPanel implements Tracable, MouseListener, MouseMotionListener, KeyListener{
    
    private PanelWest pw;
    private PanelSouth ps;
    private int x2,y2;
    private ArrayList<Tracable> stockage = new ArrayList<Tracable>();

    public PanelCentre(){
        this.setBackground(Color.white);
        this.initConnections();
    }

    public void setPanelWest(PanelWest p){
        pw = p;
    }

    public void setPanelSouth(PanelSouth p){
        ps = p;
    }
    
    public void initConnections(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("Lancement de paint ");
        for(int i=00; i<stockage.size(); i++){
            this.stockage.get(i).dessine(g);
        }
    }

    public void mousePressed(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        Graphics g = getGraphics();
        g.setColor(getCouleurActive(pw));
        g.drawLine(x2, y2, xs, ys);
        System.out.println("Enfoncement de la souris en "+xs+","+ys);
    }

    public void mouseReleased(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Relachement de la souris en "+xs+","+ys);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        int xs = mouseEvent.getX();
        int ys = mouseEvent.getY();
        Graphics g = getGraphics();
        g.setColor(getCouleurActive(pw));
        stockage.add(new Droite(this.x2, this.y2, xs, ys, getCouleurActive(pw)));
        this.x2 = xs;
        this.y2 = ys;
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        int xs = mouseEvent.getX();
        int ys = mouseEvent.getY();
        this.x2 = xs;
        this.y2 = ys;
        System.out.println("Entre en " + xs + "," + ys);
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        int xs = mouseEvent.getX();
        int ys = mouseEvent.getY();
        System.out.println("Glissement e n " + xs + "," + ys);
        stockage.add(new Droite(this.x2, this.y2, xs, ys, getCouleurActive(pw)));
        this.repaint();
        this.x2 = xs;
        this.y2 = ys;
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        this.requestFocus();
        System.out.println("Entree de la souris en " + mouseEvent.getX() + "," + mouseEvent.getY());
    }

    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("Sortie de la souris en " + mouseEvent.getX() + "," + mouseEvent.getY());
    }

    public void clearPanelCenter(){
        stockage.clear();
        this.repaint();
    }

    public void undo(){
        stockage.remove(stockage.size()-1);
        this.repaint();
    }
    
    public Color getCouleurActive(PanelWest p){
        return pw.returnCouleurActive();
    }

    public void keyPressed(KeyEvent keyEvent) {
        char keyChar = keyEvent.getKeyChar();
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.isControlDown() && keyCode == 67) {
            Graphics g = getGraphics();
            g.setColor(getCouleurActive(pw));
            g.drawOval(this.x2, this.y2, 60, 60);
        }
        if (keyEvent.isControlDown() && keyEvent.isAltDown() && keyEvent.isShiftDown() && keyCode == 68) {
            Graphics g = getGraphics();
            stockage.add(new Circle(this.x2, this.y2, 30, true, getCouleurActive(pw)));
            this.repaint();
            
        }
        if (keyEvent.isAltDown() && keyChar == 'r') {
            Graphics g = getGraphics();
            stockage.add(new Rectangle(this.x2, this.y2, 120,80, getCouleurActive(pw), true));
            this.repaint();
        }
        System.out.println("Enfoncement de la touche " + keyChar);
    }

    public void keyTyped(KeyEvent keyEvent){
        System.out.println("Touche frappee " + keyEvent.getKeyChar());
    }

    public void keyReleased(KeyEvent keyEvent){
        System.out.println("Relachement de la touche " + keyEvent.getKeyChar());
    }
}
