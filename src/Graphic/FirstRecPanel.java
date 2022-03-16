package Graphic;

import Human.Antibody;
import Human.Virus;

import javax.swing.*;
import java.awt.*;

public class FirstRecPanel extends JPanel {

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
    private int brainButtonPosition_X = 440, brainButtonPosition_Y = 95;
    private int heartButtonPosition_X = 590, heartButtonPosition_Y = 95;
    private int liverButtonPosition_X = 740, liverButtonPosition_Y = 95;
    private int carinPositionText_X = 995, carinPositionText_Y = 60;
    private int creditPositionText_X = 1125, creditPositionText_Y =165;
    private int amountOfCreditPositionText_X = 1130, amountOfCreditPositionText_Y = 220;
    private int antibodyButtonWidth = 120, antibodyButtonHeight = 120;
    private boolean updated = false;

    public FirstRecPanel(){
        this.setBackground(new Color(151,52,46));
        this.setBounds(0,0,firstRecWidth,firstRecHeight);
        this.setLayout(null);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;

        //amount of antibody's text on first Rec
        Font font = new Font("Roboto Condensed",Font.PLAIN,36);
        g2D.setFont(font);
        FontMetrics fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("Antibody: ",antiPositionText_X,antiPositionText_Y+fontMetrics.getAscent());
        g2D.drawString(String.valueOf(Antibody.getAmountOfAntibody()),amountOfAntiPositionText_X,amountOfAntiPositionText_Y + fontMetrics.getAscent());

        //amount of virus's text on first Rec
        font = new Font("Roboto Condensed",Font.PLAIN,36);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("Virus: ",virusPositionText_X,virusPositionText_Y+fontMetrics.getAscent());
        g2D.drawString(String.valueOf(Virus.getAmountOfVirus()),amountOfVirusPositionText_X,amountOfVirusPositionText_Y + fontMetrics.getAscent());

    }

//    public void createButtonForShopRec(){
//
//    }
}
