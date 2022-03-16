package Graphic;

import javax.swing.*;
import java.awt.*;

public class cellPanel extends JPanel{
    private JPanel organScreen = new JPanel(new CardLayout());
    private BrainCellPanel brainCell = new BrainCellPanel(organScreen);
    private HeartCellPanel heartCell = new HeartCellPanel(organScreen);
    private LiverCellPanel liverCell = new LiverCellPanel(organScreen);

    public cellPanel(){
        setOpaque(true);
        this.setLayout(null);
        this.setBounds(0,220,900,500);
        this.setBackground(new Color(151,52,46));

        this.add(organScreen);
        organScreen.setBounds(0,0,900,500);
//        organScreen.setBackground(Color.white);
        organScreen.add(brainCell,"brainCell");
        organScreen.add(heartCell,"heartCell");
        organScreen.add(liverCell,"liverCell");
//        this.setContentPane(organScreen);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;
}

}
