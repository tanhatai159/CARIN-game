package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellPanel extends JPanel {
    private int cellPanelWidth = 900,cellPanelHeight = 500;
    private GridPanel grid = new GridPanel();

    public CellPanel(){
        setOpaque(true);
        this.setLayout(null);
        this.setBounds(0,220,cellPanelWidth,cellPanelHeight);
        this.setBackground(Color.white);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;

        add(grid);
        grid.setBounds(0,220,900,500);
    }
}

