package Graphic;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel{

     BrainCellPanel brainCell = new BrainCellPanel();
     HeartCellPanel heartCell = new HeartCellPanel();
     LiverCellPanel liverCell = new LiverCellPanel();

    public CellPanel(){
        setOpaque(true);
        this.setLayout(null);
        this.setBounds(0,0,900,720);
        this.setBackground(Color.white);


        this.add(brainCell,"brainCell");
        this.add(heartCell,"heartCell");
        this.add(liverCell,"liverCell");

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;
}

}
