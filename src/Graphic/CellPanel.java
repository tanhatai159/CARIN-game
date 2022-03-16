package Graphic;

import Human.Cell;
import Human.Organ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CellPanel extends JPanel {
    private int cellPanelWidth = 900,cellPanelHeight = 500;
    private ArrayList<JButton> button = new ArrayList<>();
    private int x =100;
//    private GridPanel grid = new GridPanel();

    public CellPanel(){
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
                JButton button = new JButton("");
                button.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
//                button.setBounds(x*i+5,x*i+5,100,100);
                this.add(button);
            }

        }



    }
//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//        Graphics g2D = (Graphics2D) g;
//    }
}

