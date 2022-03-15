package Graphic;

import Human.Body;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    GameScreen gameScreen;
    StartScreen startScreen;

    public MainFrame(){
        //for inside game
        JPanel contentPane = new JPanel();
        startScreen = new StartScreen(contentPane);
        gameScreen = new GameScreen(contentPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new CardLayout());
        contentPane.add(startScreen);
        contentPane.add(gameScreen);

        this.setContentPane(contentPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void render(){
        repaint();
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
        while (true){
            m.render();
        }
    }
}
