package Graphic;

import javax.swing.*;

public class mainFrame extends JFrame {

    private GameScreen gameScreen;
    private int trioButtonWidth = 120, trioButtonHeight = 60;
    private int brainButtonPosition_X = 440, brainButtonPosition_Y = 600;
    private JButton brainButton, heartButton, liverButton;

    public mainFrame(){
        //for inside game
        gameScreen = new GameScreen();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        brainButton = new JButton("hello");
        brainButton.setBounds(brainButtonPosition_X,brainButtonPosition_Y,trioButtonWidth,trioButtonHeight);

        gameScreen.add(brainButton);
        this.add(gameScreen);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        mainFrame m = new mainFrame();
    }
}
