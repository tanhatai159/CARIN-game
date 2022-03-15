package Graphic;

import Human.Antibody;
import Human.Virus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JPanel {

    private JPanel contentPane;
    private JFrame mainScreen;
    private int windowWidth = 1280, windowHeight = 720;
    private int firstRecWidth = 900, firstRecHeight = 220;
    private int shopRecWidth = 380, shopRecHeight = 720;
    private int backgroundWidth = 900, backgroundHeight = 500;
    private int antiPositionText_X = 60, antiPositionText_Y = 60;
    private int amountOfAntiPositionText_X = antiPositionText_X + 160, amountOfAntiPositionText_Y = antiPositionText_Y;
    private int virusPositionText_X = 60, virusPositionText_Y = 130;
    private int amountOfVirusPositionText_X = virusPositionText_X + 100, amountOfVirusPositionText_Y = virusPositionText_Y;
    private JButton brainButton, heartButton, liverButton, antiRedButton, antiGreenButton, antiBlueButton, buyButton, doneButton,exitButton;
    private Icon antiRed = new ImageIcon("src/resource/redAnti.png");
    private Icon antiGreen = new ImageIcon("src/resource/greenAnti.png");
    private Icon antiBlue = new ImageIcon("src/resource/blueAnti.png");
    private int trioButtonWidth = 120, trioButtonHeight = 60;
    private int brainButtonPosition_X = 440, brainButtonPosition_Y = 95;
    private int heartButtonPosition_X = 590, heartButtonPosition_Y = 95;
    private int liverButtonPosition_X = 740, liverButtonPosition_Y = 95;
    private int carinPositionText_X = 995, carinPositionText_Y = 60;
    private int creditPositionText_X = 1125, creditPositionText_Y =165;
    private int amountOfCreditPositionText_X = 1130, amountOfCreditPositionText_Y = 220;
    private int antibodyButtonWidth = 120, antibodyButtonHeight = 120;
    private int antiRedButtonPosition_X = 945, antiRedButtonPosition_Y = 295;
    private int antiGreenButtonPosition_X = 1115, antiGreenButtonPosition_Y = 295;
    private int antiBlueButtonPosition_X = 945, antiBlueButtonPosition_Y = 470;
    private int buyButtonPosition_X = 1115, buyButtonPosition_Y = 470;
    private int doneButtonPosition_X = 1115, doneButtonPosition_Y = 550;
    private int costRedPositionAnti_X = 955, costRedPositionAnti_Y = 420;
    private int costBluePositionAnti_X = 955, costBluePositionAnti_Y = 600;
    private int costGreenPositionAnti_X = 1125, costGreenPositionAnti_Y = 420;
    private int exitButtonPosition_X = 945, exitButtonPosition_Y = 650;
    private int exitButtonWidth = 290, exitButtonHeight = 50;
    private Icon elementImage = new ImageIcon("src/resource/element.png");
    private JLabel element =  new JLabel(elementImage);
    private int elementPosition_X = 955, elementPosition_Y = 165;

    public GameScreen(JPanel panel){
        contentPane = panel;
        setOpaque(true);
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setLayout(null);
        createButtonForFirstRec();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
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

        //CARIN header on Shop Rec
        font = new Font("Roboto Condensed",Font.PLAIN,80);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("CARIN",carinPositionText_X,carinPositionText_Y+fontMetrics.getAscent());

        //element image
        this.add(element);
        element.setBounds(elementPosition_X,elementPosition_Y,100,100);

        //Credits text
        font = new Font("Roboto Condensed",Font.PLAIN,36);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("Credits:",creditPositionText_X,creditPositionText_Y+fontMetrics.getAscent());

        //CreditAmount Text
        font = new Font("Roboto Condensed",Font.PLAIN,36);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString(String.valueOf(200),amountOfCreditPositionText_X,amountOfCreditPositionText_Y + fontMetrics.getAscent());
        g2D.drawString("$",amountOfCreditPositionText_X+85,amountOfCreditPositionText_Y+fontMetrics.getAscent());

        //cost redAntibody
        font = new Font("Roboto Condensed",Font.PLAIN,24);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("COST: " + String.valueOf(Antibody.getPlacementCost())+ "$",costRedPositionAnti_X,costRedPositionAnti_Y+fontMetrics.getAscent());

        //cost greenAntibody
        font = new Font("Roboto Condensed",Font.PLAIN,24);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("COST: " + String.valueOf(Antibody.getPlacementCost()) + "$",costGreenPositionAnti_X,costGreenPositionAnti_Y+fontMetrics.getAscent());

        //cost blueAntibody
        font = new Font("Roboto Condensed",Font.PLAIN,24);
        g2D.setFont(font);
        fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("COST: " + String.valueOf(Antibody.getPlacementCost() + "$"),costBluePositionAnti_X,costBluePositionAnti_Y+fontMetrics.getAscent());




    }

    public void createButtonForFirstRec(){
        //brain button
        brainButton = new JButton("BRAIN");
        brainButton.setBackground(new Color(222,156,151));
        brainButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        brainButton.setBounds(brainButtonPosition_X,brainButtonPosition_Y,trioButtonWidth,trioButtonHeight);

        //heart button
        heartButton = new JButton("HEART");
        heartButton.setBackground(new Color(222,156,151));
        heartButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        heartButton.setBounds(heartButtonPosition_X,heartButtonPosition_Y,trioButtonWidth,trioButtonHeight);

        //liver button
        liverButton = new JButton("LIVER");
        liverButton.setBackground(new Color(222,156,151));
        liverButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        liverButton.setBounds(liverButtonPosition_X,liverButtonPosition_Y,trioButtonWidth,trioButtonHeight);

        //AntivirusRed button
        antiRedButton = new JButton(antiRed);
        antiRedButton.setBackground(new Color(240,191,187));
        antiRedButton.setBounds(antiRedButtonPosition_X,antiRedButtonPosition_Y,antibodyButtonWidth,antibodyButtonHeight);

        //AntivirusGreen button
        antiGreenButton = new JButton(antiGreen);
        antiGreenButton.setBackground(new Color(240,191,187));
        antiGreenButton.setBounds(antiGreenButtonPosition_X,antiGreenButtonPosition_Y,antibodyButtonWidth,antibodyButtonHeight);

        //AntivirusBlue button
        antiBlueButton = new JButton(antiBlue);
        antiBlueButton.setBackground(new Color(240,191,187));
        antiBlueButton.setBounds(antiBlueButtonPosition_X,antiBlueButtonPosition_Y,antibodyButtonWidth,antibodyButtonHeight);

        // buyButton
        buyButton = new JButton("BUY");
        buyButton.setForeground(Color.white);
        buyButton.setBackground(new Color(193,82,75));
        buyButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        buyButton.setBounds(buyButtonPosition_X,buyButtonPosition_Y,trioButtonWidth,trioButtonHeight);

        //doneButton
        doneButton = new JButton("DONE");
        doneButton.setForeground(Color.white);
        doneButton.setBackground(new Color(193,82,75));
        doneButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        doneButton.setBounds(doneButtonPosition_X,doneButtonPosition_Y,trioButtonWidth,trioButtonHeight);

        //exitButton
        exitButton = new JButton("EXIT");
        exitButton.setForeground(Color.white);
        exitButton.setBackground(new Color(151,52,46));
        exitButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        exitButton.setBounds(exitButtonPosition_X,exitButtonPosition_Y,exitButtonWidth,exitButtonHeight);
        exitButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {System.exit(0);}
        });

        this.add(brainButton);
        this.add(heartButton);
        this.add(liverButton);
        this.add(antiRedButton);
        this.add(antiGreenButton);
        this.add(antiBlueButton);
        this.add(buyButton);
        this.add(doneButton);
        this.add(exitButton);

    }

    public void createButtonForShopRec(){

    }
}
