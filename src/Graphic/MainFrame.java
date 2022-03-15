package Graphic;

import javax.swing.*;

public class MainFrame extends JFrame {

    GameScreen gameScreen;

    public MainFrame(){
        //for inside game
        gameScreen = new GameScreen();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(gameScreen);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
    }
}
