import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PanelSouth extends JPanel{

    private PanelCentre pc;
    private JComboBox cbForme;
    private Tracable tracableCourrent;

    public Tracable getTracableCourrent(){
        return tracableCourrent;
    }

    public PanelSouth(){
        this.SetPanelSouth();
    }

    public void setPanelCentre(PanelCentre p){
        pc=p;
    }

    /*public void setForme(PanelCentre p){
        
    }*/

    

    public void SetPanelSouth(){
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        cbForme = new JComboBox<>();
        for(int i=0; i<Constantes.formes.length; i++){
            cbForme.addItem(Constantes.formes[i]);
        }
        /*if(cbForme.getSelectedItem(Constantes.formes[1])){
            cbForme.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("fonctionne");
                }
            });
        };*/

        ButtonGroup groupButton = new ButtonGroup();
        JRadioButton rbtnVide = new JRadioButton("Vide");
        JRadioButton rbtnPlein = new JRadioButton("Plein");
        rbtnVide.setSelected(true);
        groupButton.add(rbtnVide);
        groupButton.add(rbtnPlein);  
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                pc.clearPanelCenter();
            }
        });
        JButton btnUndo = new JButton("Undo");
        btnUndo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                pc.undo();
            }
        });

        /*JButton btnGomme = new JButton("Gomme");
        btnGomme.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {

            }
        });*/

        add(cbForme);
        add(rbtnVide);
        add(rbtnPlein);
        //add(btnGomme);
        add(btnUndo);
        add(btnClear);  
    }

}