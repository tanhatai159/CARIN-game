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
    private int backgroundWidth = 900, backgroundHeight = 500;
    private JButton brainButton, heartButton, liverButton;
    private int trioButtonWidth = 120, trioButtonHeight = 60;
    private int brainButtonPosition_X = 440, brainButtonPosition_Y = 120;
    private int heartButtonPosition_X = 590, heartButtonPosition_Y = 120;
    private int liverButtonPosition_X = 740, liverButtonPosition_Y = 120;

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
