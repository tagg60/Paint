import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PanelWest extends JPanel implements Tracable, MouseListener, MouseMotionListener, KeyListener{

    Color couleurActive;

    public PanelWest(){
        this.setBackground(Color.WHITE);
        setPanelWest();
    }

    public Color returnCouleurActive(){
        return couleurActive;
    }

    public void setPanelWest(){
        
        Graphics g = getGraphics();
        GridLayout gl = new GridLayout(6,2);
        setLayout(gl);
        for(int i=0; i<Constantes.couleur.length; i++){
            JButton btnCouleur = new JButton();
            btnCouleur.setBackground(Constantes.couleur[i]);
            btnCouleur.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    couleurActive = btnCouleur.getBackground();
                }
            });
            add(btnCouleur); 
        }
        JButton btnChooserCouleur = new JButton("Palette");
        btnChooserCouleur.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                Color c =JColorChooser.showDialog(PanelWest.this, "Sélection...",getBackground());
                couleurActive = c;
            }
        });
        add(btnChooserCouleur);
    }
}
