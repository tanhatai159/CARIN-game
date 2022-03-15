package Graphic;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class StartScreen extends JPanel{
    private JPanel contentPane;
    private JFrame mainScreen;
    private Icon startMenuImage = new ImageIcon("src/resource/startMenu.png");
    private JLabel startMenu =  new JLabel(startMenuImage);
    private int windowWidth = 1280, windowHeight = 720;
    private JButton startButton;
    private int startButtonPosition_X = 540, startButtonPosition_Y = 400;
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
                cardLayout.next(contentPane);
            }
        });
        startButton.setBackground(new Color(222,156,151));
        startButton.setForeground(Color.white);
        startButton.setFont(new Font("Roboto Condensed",Font.PLAIN,60));
        startButton.setBounds(startButtonPosition_X,startButtonPosition_Y,startButtonWidth,startButtonHeight);


        this.add(startButton);
    }



}
