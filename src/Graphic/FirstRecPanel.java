package Graphic;

import Human.Antibody;
import Human.Virus;
import MainClass.GameStates;
import MainClass.MainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static MainClass.GameStates.generateVirus;

public class FirstRecPanel extends JPanel {

    private int firstRecWidth = 900, firstRecHeight = 220;
    private int antiPositionText_X = 60, antiPositionText_Y = 60;
    private int amountOfAntiPositionText_X = antiPositionText_X + 160, amountOfAntiPositionText_Y = antiPositionText_Y;
    private int virusPositionText_X = 60, virusPositionText_Y = 130;
    private int amountOfVirusPositionText_X = virusPositionText_X + 100, amountOfVirusPositionText_Y = virusPositionText_Y;
    private int timeUnitPosition_X = 440, timeUnitPosition_Y = 60;

    public FirstRecPanel(){
        this.setBackground(new Color(151,52,46));
        this.setBounds(0,0,firstRecWidth,firstRecHeight);
        this.setLayout(null);
//        createButtonForFirstRec();
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

        //timeUnit
        font = new Font("Roboto Condensed",Font.PLAIN,36);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("Time Unit: " +MainGame.getTimeUnit(),timeUnitPosition_X,timeUnitPosition_Y+fontMetrics.getAscent());
    }
}
