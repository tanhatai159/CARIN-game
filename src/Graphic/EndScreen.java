package Graphic;

import Human.Antibody;
import MainClass.GameStates;
import MainClass.MainGame;
import MainClass.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static MainClass.GameStates.generateVirus;

public class EndScreen extends JPanel
{
    private JPanel contentPane;
    private Icon startMenuImage = new ImageIcon("src/resource/startMenu.png");
    private JLabel startMenu =  new JLabel(startMenuImage);
    private int windowWidth = 1280, windowHeight = 720;
    private JButton startButton,exitButton;
    private int statusPosition_X = 400, statusPosition_Y = 250;
    private int exitButtonPosition_X = 520, exitButtonPosition_Y = 400;
    private int startButtonWidth = 200, startButtonHeight =100;
    private String status;


    public EndScreen(JPanel panel){
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

        //win/loose text

        if (MainGame.getPlayerWin()){
            status = "WIN";
        }else {
            status = "LOSE";
        }

        Font font = new Font("Roboto Condensed",Font.PLAIN,100);
        g2D.setFont(font);
        FontMetrics fontMetrics = g2D.getFontMetrics();
        g2D.setColor(Color.white);
        g2D.drawString("YOU "+status+"!!!",statusPosition_X,statusPosition_Y+fontMetrics.getAscent());
    }
    public void createButton(){
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

        this.add(exitButton);
    }
}
