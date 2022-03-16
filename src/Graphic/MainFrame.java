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
    EndScreen endScreen;
    private ArrayList<JPanel> allScreen = new ArrayList<>();

    public MainFrame(){
        //for inside game
        JPanel contentPane = new JPanel();
        startScreen = new StartScreen(contentPane);
        gameScreen = new GameScreen(contentPane);
        endScreen = new EndScreen(contentPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new CardLayout());
        contentPane.add(startScreen, "startScreen");
        contentPane.add(gameScreen, "gameScreen");
        contentPane.add(endScreen, "endScreen");

        this.setContentPane(contentPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void render(){
        repaint();
        if(gameStates != menu && gameStates != end){
            CellPanel.updateButton();
        }else if(gameStates == end){
            gameScreen.setVisible(false);
            endScreen.setVisible(true);
        }
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
    }

}
