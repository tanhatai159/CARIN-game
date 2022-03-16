package Graphic;

import Human.Organ;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HeartCellPanel extends JPanel{
    private int cellPanelWidth = 900,cellPanelHeight = 500;
    private ArrayList<JButton> button = new ArrayList<>();
    private int x =100;
    private JPanel contentPane;

    public HeartCellPanel(JPanel panel){
        contentPane = panel;
        setOpaque(true);

        this.setLayout(null);
        this.setBounds(0,220,cellPanelWidth,cellPanelHeight);
        this.setBackground(Color.red);
        this.setLayout(new GridLayout(Organ.getM(),Organ.getN()));
        createButtonForFirstRec();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;
    }
    public void createButtonForFirstRec(){
        for(int i=0;i<Organ.getM();i++){
            for (int j = 0; j < Organ.getN(); j++) {
                JButton button = new CellButton();
                button.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
                button.setBackground(new Color(151,52,46));
                this.add(button);
            }
        }
}

}
