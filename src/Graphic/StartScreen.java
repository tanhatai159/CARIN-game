package Graphic;


import MainClass.GameStates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static MainClass.GameStates.*;


public class StartScreen extends JPanel{
    private JPanel contentPane;
    private Icon startMenuImage = new ImageIcon("src/resource/startMenu.png");
    private JLabel startMenu =  new JLabel(startMenuImage);
    private int windowWidth = 1280, windowHeight = 720;
    private JButton startButton,exitButton;
    private int startButtonPosition_X = 340, startButtonPosition_Y = 450;
    private int exitButtonPosition_X = 740, exitButtonPosition_Y = 450;
    private int startButtonWidth = 200, startButtonHeight =100;
    private int startMenuPosition_X = 140, startMenuPosition_Y = 100;
    private int startMenuWidth = 1000, startMenuHeight = 300;


    public StartScreen(JPanel panel){
        contentPane = panel;
        setOpaque(true);
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setLayout(null);
        createButton();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;

        //bg color
        g2D.setColor(new Color(151,52,46));
        g2D.fillRect(0,0,windowWidth,windowHeight);

        //start menu image
        this.add(startMenu);
        startMenu.setBounds(startMenuPosition_X,startMenuPosition_Y,startMenuWidth,startMenuHeight);
    }
    public void createButton(){

        startButton = new JButton("Start");
        startButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//                cardLayout.next(contentPane);
                cardLayout.show(contentPane, "gameScreen");

                GameStates.gameStates = generateVirus;

            }
        });
        startButton.setBackground(new Color(222,156,151));
        startButton.setForeground(Color.white);
        startButton.setFont(new Font("Roboto Condensed",Font.PLAIN,60));
        startButton.setBounds(startButtonPosition_X,startButtonPosition_Y,startButtonWidth,startButtonHeight);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        exitButton.setBackground(new Color(222,156,151));
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Roboto Condensed",Font.PLAIN,60));
        exitButton.setBounds(exitButtonPosition_X,exitButtonPosition_Y,startButtonWidth,startButtonHeight);

        this.add(startButton);
        this.add(exitButton);
    }



}
