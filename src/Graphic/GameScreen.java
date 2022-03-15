package Graphic;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    private JFrame mainScreen;
    private int windowWidth = 1280, windowHeight = 720;
    private int firstRecWidth = 900, firstRecHeight = 220;
    private int shopRecWidth = 380, shopRecHeight = 720;
    private int backgroundWidth = 900, backgroundHeight = 500;
    private int antiPositionText_X = 60, antiPositionText_Y = 60;
    private int amountOfAntiPositionText_X = antiPositionText_X + 160, amountOfAntiPositionText_Y = antiPositionText_Y;
    private int virusPositionText_X = 60, virusPositionText_Y = 130;
    private int amountOfVirusPositionText_X = virusPositionText_X + 100, amountOfVirusPositionText_Y = virusPositionText_Y;
    private JButton brainButton, heartButton, liverButton;
    private int trioButtonWidth = 120, trioButtonHeight = 60;
    private int brainButtonPosition_X = 440, brainButtonPosition_Y = 600;
    private int heartButtonPosition_X = 0, heartButtonPosition_Y = 0;
    private int liverButtonPosition_X = 0, liverButtonPosition_Y = 0;

    public GameScreen(){

        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        //brain button
//        brainButton = new JButton("hello");
//        brainButton.setPreferredSize(new Dimension(trioButtonWidth,trioButtonHeight));
//        brainButton.setLocation(new Point(brainButtonPosition_X,brainButtonPosition_Y));
//        brainButton.setLocation(brainButtonPosition_X,brainButtonPosition_Y);
//        brainButton.setBounds(brainButtonPosition_X,brainButtonPosition_Y,trioButtonWidth,trioButtonHeight);
//        this.add(brainButton);
    }
    public void paint(Graphics g){
        Graphics g2D = (Graphics2D) g;

        //first Rec
        g2D.setColor(new Color(151,52,46));
        g2D.fillRect(0,0,firstRecWidth,firstRecHeight);

        //shop Rec
        g2D.setColor(new Color(222,156,151));
        g2D.fillRect(firstRecWidth,0,shopRecWidth,shopRecHeight);

        //background Rec
        g2D.setColor(new Color(193,82,75));
        g2D.fillRect(0,firstRecHeight,backgroundWidth,backgroundHeight);

        //amount of antibody's text on first Rec
        Font font = new Font("Roboto",Font.PLAIN,36);
        g2D.setFont(font);
        FontMetrics fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("Antibody: ",antiPositionText_X,antiPositionText_Y+fontMetrics.getAscent());
        g2D.drawString(String.valueOf(200),amountOfAntiPositionText_X,amountOfAntiPositionText_Y + fontMetrics.getAscent());

        //amount of antibody's text on first Rec
        font = new Font("Roboto",Font.PLAIN,36);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("Virus: ",virusPositionText_X,virusPositionText_Y+fontMetrics.getAscent());
        g2D.drawString(String.valueOf(200),amountOfVirusPositionText_X,amountOfVirusPositionText_Y + fontMetrics.getAscent());

    }
}
