package Graphic;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel{

     BrainCellPanel brainCell = new BrainCellPanel();
     HeartCellPanel heartCell = new HeartCellPanel();
     LiverCellPanel liverCell = new LiverCellPanel();
     public static boolean wasClicked = false;
     public static int x, y;
     public static int oldCellIndex;

    public CellPanel(){
        setOpaque(true);
        this.setLayout(null);
        this.setBounds(0,0,900,720);
        this.setBackground(Color.white);
        this.add(brainCell,"brainCell");
        this.add(heartCell,"heartCell");
        this.add(liverCell,"liverCell");
    }

    public static void updateButton(){
        BrainCellPanel.updateButton();
        HeartCellPanel.updateButton();
        LiverCellPanel.updateButton();
    }
}
