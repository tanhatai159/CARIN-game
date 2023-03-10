package Graphic;

import Human.Antibody;
import MainClass.GameStates;
import MainClass.MainGame;
import MainClass.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static MainClass.GameStates.*;

public class ShopRecPanel extends JPanel {

    private int speedPositionButton_X = 45, speedPositionButton_Y = 650;
    private int speedButtonWidth = 70, speedButtonHeight = 50;
    private int windowWidth = 1280, windowHeight = 720;
    private int firstRecWidth = 900, firstRecHeight = 220;
    private int shopRecWidth = 380, shopRecHeight = 720;
    private int antiPositionText_X = 60, antiPositionText_Y = 60;
    private int amountOfAntiPositionText_X = antiPositionText_X + 160, amountOfAntiPositionText_Y = antiPositionText_Y;
    private int virusPositionText_X = 60, virusPositionText_Y = 130;
    private int amountOfVirusPositionText_X = virusPositionText_X + 100, amountOfVirusPositionText_Y = virusPositionText_Y;
    private static JButton antiRedButton, antiGreenButton, antiBlueButton, buyButton, doneButton,exitButton, speedButton;
    private Icon antiRed = new ImageIcon("src/resource/redAntiButton.png");
    private Icon antiGreen = new ImageIcon("src/resource/greenAntiButton.png");
    private Icon antiBlue = new ImageIcon("src/resource/blueAntiButton.png");
    private int trioButtonWidth = 120, trioButtonHeight = 60;
    private int carinPositionText_X = 85, carinPositionText_Y = 60;
    private int creditPositionText_X = 225, creditPositionText_Y =165;
    private int amountOfCreditPositionText_X = 230, amountOfCreditPositionText_Y = 220;
    private int antibodyButtonWidth = 120, antibodyButtonHeight = 120;
    private int antiRedButtonPosition_X = 45, antiRedButtonPosition_Y = 295;
    private int antiGreenButtonPosition_X = 215, antiGreenButtonPosition_Y = 295;
    private int antiBlueButtonPosition_X = 45, antiBlueButtonPosition_Y = 470;
    private int buyButtonPosition_X = 215, buyButtonPosition_Y = 470;
    private int doneButtonPosition_X = 215, doneButtonPosition_Y = 550;
    private int costRedPositionAnti_X = 55, costRedPositionAnti_Y = 420;
    private int costBluePositionAnti_X = 55, costBluePositionAnti_Y = 600;
    private int costGreenPositionAnti_X = 225, costGreenPositionAnti_Y = 420;
    private int exitButtonPosition_X = 120, exitButtonPosition_Y = 650;
    private int exitButtonWidth = 215, exitButtonHeight = 50;
    private Icon elementImage = new ImageIcon("src/resource/element.png");
    private JLabel element =  new JLabel(elementImage);
    private int elementPosition_X = 55, elementPosition_Y = 165;
    private static boolean buyButtonClicked = false;
    private static int elementIndex = 0;
    private static int choosedElementIndex = 0;

    public ShopRecPanel(){
        setOpaque(true);
        this.setLayout(null);
        this.setBounds(firstRecWidth,0,shopRecWidth,shopRecHeight);
        this.setBackground(new Color(222,156,151));
        createButtonForShopRec();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;
        Font font;
        FontMetrics fontMetrics = g2D.getFontMetrics();

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
        g2D.drawString(String.valueOf(Player.getCredits() + "$"),amountOfCreditPositionText_X,amountOfCreditPositionText_Y + fontMetrics.getAscent());
//        g2D.drawString("$",amountOfCreditPositionText_X+85,amountOfCreditPositionText_Y+fontMetrics.getAscent());

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

    public void createButtonForShopRec(){
        //AntivirusRed button
        antiRedButton = new JButton(antiRed);
        antiRedButton.setBackground(new Color(240,191,187));
        antiRedButton.setBounds(antiRedButtonPosition_X,antiRedButtonPosition_Y,antibodyButtonWidth,antibodyButtonHeight);
        antiRedButton.addActionListener(e -> {
            if(gameStates == playerAction){
                elementIndex = 1;
                if(buyButtonClicked){
                    buyButtonClicked = false;
                }
                CellPanel.wasClicked = false;
                updateButton();
            }
        });

        //AntivirusGreen button
        antiGreenButton = new JButton(antiGreen);
        antiGreenButton.setBackground(new Color(240,191,187));
        antiGreenButton.setBounds(antiGreenButtonPosition_X,antiGreenButtonPosition_Y,antibodyButtonWidth,antibodyButtonHeight);
        antiGreenButton.addActionListener(e ->{
            if(gameStates == playerAction){
                elementIndex = 3;
                if(buyButtonClicked){
                    buyButtonClicked = false;
                }
                CellPanel.wasClicked = false;
                updateButton();
            }
        });


        //AntivirusBlue button
        antiBlueButton = new JButton(antiBlue);
        antiBlueButton.setBackground(new Color(240,191,187));
        antiBlueButton.setBounds(antiBlueButtonPosition_X,antiBlueButtonPosition_Y,antibodyButtonWidth,antibodyButtonHeight);
        antiBlueButton.addActionListener(e ->{
            elementIndex = 2;
            if(buyButtonClicked){
                buyButtonClicked = false;
            }
            CellPanel.wasClicked = false;
            updateButton();
        });

        // buyButton
        buyButton = new JButton("BUY");
        buyButton.setForeground(Color.white);
        buyButton.setBackground(new Color(193,82,75));
        buyButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        buyButton.setBounds(buyButtonPosition_X,buyButtonPosition_Y,trioButtonWidth,trioButtonHeight);
        buyButton.addActionListener(e ->{
            if(gameStates == playerAction){
                if(!buyButtonClicked && !CellPanel.wasClicked && elementIndex > 0){
                    buyButtonClicked = true;
                    choosedElementIndex = elementIndex;
                    elementIndex = 0;
                    updateButton();
                }
                CellPanel.wasClicked = false;
            }
        });

        //doneButton
        doneButton = new JButton("DONE");
        doneButton.setForeground(Color.white);
        doneButton.setBackground(new Color(193,82,75));
        doneButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        doneButton.setBounds(doneButtonPosition_X,doneButtonPosition_Y,trioButtonWidth,trioButtonHeight);
        doneButton.addActionListener(e -> {
            if(gameStates == playerAction && !buyButtonClicked && !CellPanel.wasClicked){
                gameStates = cellAction;
                elementIndex = 0;
                updateButton();
            }
            CellPanel.wasClicked = false;
        });

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


        speedButton = new JButton("X"+ MainGame.gameSpeed);
        speedButton.setForeground(Color.white);
        speedButton.setBackground(new Color(151,52,46));
        speedButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        speedButton.setBounds(speedPositionButton_X,speedPositionButton_Y,speedButtonWidth,speedButtonHeight);
        speedButton.addActionListener(e ->{
            if(MainGame.gameSpeed == 1){
                MainGame.gameSpeed = 2;
                speedButton.setText("X"+ MainGame.gameSpeed);
            }
            else{
                MainGame.gameSpeed = 1;
                speedButton.setText("X"+ MainGame.gameSpeed);
            }
        });


        this.add(antiRedButton);
        this.add(antiGreenButton);
        this.add(antiBlueButton);
        this.add(buyButton);
        this.add(doneButton);
        this.add(speedButton);
        this.add(exitButton);
    }

    public static void updateButton(){
        if(elementIndex == 1){
            antiRedButton.setBorder(BorderFactory.createLineBorder(new Color(193,82,75), 5));
            antiBlueButton.setBorder(null);
            antiGreenButton.setBorder(null);
        }
        else if(elementIndex == 2){
            antiBlueButton.setBorder(BorderFactory.createLineBorder(new Color(193,82,75), 5));
            antiRedButton.setBorder(null);
            antiGreenButton.setBorder(null);
        }
        else if(elementIndex == 3){
            antiGreenButton.setBorder(BorderFactory.createLineBorder(new Color(193,82,75), 5));
            antiRedButton.setBorder(null);
            antiBlueButton.setBorder(null);
        }
        else {
            antiRedButton.setBorder(null);
            antiBlueButton.setBorder(null);
            antiGreenButton.setBorder(null);
        }
    }

    public static boolean getBuyButtonClicked(){
        return buyButtonClicked;
    }

    public static void setBuyButtonClicked(boolean status){
        buyButtonClicked = status;
    }

    public static int getChoosedElementIndex(){
        return choosedElementIndex;
    }

    public static void setElementIndex(int index){
        elementIndex = index;
    }

}
