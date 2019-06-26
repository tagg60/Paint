import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Paint{
    public static void main(String args[]){
        new PremDessin(" ");
    }
}
class PremDessin extends JFrame{

    PremDessin(String titre){
        super(titre);
        this.setBackground(Color.white);
        this.Initialisation();
        this.setSize(800, 500);
        this.show();
        System.out.println("Initialisation");
    }
    public void Initialisation(){
        // Placement des jpanels ici
        PanelWest pw =new PanelWest();
        PanelCentre pc =new PanelCentre();
        PanelSouth ps = new PanelSouth();
        pc.setPanelWest(pw);
        ps.setPanelCentre(pc);
        this.add(pc, BorderLayout.CENTER);
        this.add(pw,BorderLayout.WEST);
        this.add(ps, BorderLayout.SOUTH);
    }
}


 

