package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JPanel {

    private JPanel contentPane;
    private JFrame mainScreen;
    private CellPanel cell = new CellPanel();
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
    private boolean updated = false;


    public GameScreen(JPanel panel){
        contentPane = panel;
        setOpaque(true);
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setLayout(null);
        createButtonForFirstRec();
        this.add(new FirstRecPanel());
        this.add(new ShopRecPanel());
        this.add(cell);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;

        //background Rec
        g2D.setColor(new Color(193,82,75));
        g2D.fillRect(0,firstRecHeight,backgroundWidth,backgroundHeight);
    }

    public void createButtonForFirstRec(){
        //brain button
        brainButton = new JButton("BRAIN");
        brainButton.setBackground(new Color(222,156,151));
        brainButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        brainButton.setBounds(brainButtonPosition_X,brainButtonPosition_Y,trioButtonWidth,trioButtonHeight);
        brainButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cell.brainCell.setVisible(true);
                cell.liverCell.setVisible(false);
                cell.heartCell.setVisible(false);
                CellPanel.updateButton();
            }});

        //heart button
        heartButton = new JButton("HEART");
        heartButton.setBackground(new Color(222,156,151));
        heartButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        heartButton.setBounds(heartButtonPosition_X,heartButtonPosition_Y,trioButtonWidth,trioButtonHeight);
        heartButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cell.brainCell.setVisible(false);
                cell.heartCell.setVisible(true);
                cell.liverCell.setVisible(false);
                CellPanel.updateButton();
            }});

        //liver button
        liverButton = new JButton("LIVER");
        liverButton.setBackground(new Color(222,156,151));
        liverButton.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
        liverButton.setBounds(liverButtonPosition_X,liverButtonPosition_Y,trioButtonWidth,trioButtonHeight);
        liverButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cell.brainCell.setVisible(false);
                cell.liverCell.setVisible(true);
                cell.heartCell.setVisible(false);
                CellPanel.updateButton();
            }});

        this.add(brainButton);
        this.add(heartButton);
        this.add(liverButton);
    }

}
