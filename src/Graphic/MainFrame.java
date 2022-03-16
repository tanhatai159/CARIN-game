package Graphic;

import Human.Body;
import MainClass.GameStates;
import MainClass.ReadConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static MainClass.GameStates.*;

public class MainFrame extends JFrame {

    GameScreen gameScreen;
    StartScreen startScreen;
    private ArrayList<JPanel> allScreen = new ArrayList<>();

    public MainFrame(){
        //for inside game
        JPanel contentPane = new JPanel();
        startScreen = new StartScreen(contentPane);
        gameScreen = new GameScreen(contentPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new CardLayout());
        contentPane.add(startScreen, "startScreen");
        contentPane.add(gameScreen, "gameScreen");

        this.setContentPane(contentPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void render(){
        repaint();
        if(gameStates != menu){
            CellPanel.updateButton();
        }
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
        while (true){
            m.render();
        }
    }
}
