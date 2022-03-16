package Graphic;

import Human.*;
import MainClass.MainGame;
import MainClass.Market;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static MainClass.GameStates.gameStates;
import static MainClass.GameStates.playerAction;

public class HeartCellPanel extends JPanel{
    private int cellPanelWidth = 900,cellPanelHeight = 500;
    private static ArrayList<CellButton> buttons = new ArrayList<>();
    private static Organ organ = Body.getAllOrgan().get(1);
    private static Icon redVirus = new ImageIcon("src/resource/redVirus.png");
    private static Icon greenVirus = new ImageIcon("src/resource/greenVirus.png");
    private static Icon blueVirus = new ImageIcon("src/resource/blueVirus.png");
    private static Icon redAnti = new ImageIcon("src/resource/redAnti.png");
    private static Icon greenAnti = new ImageIcon("src/resource/greenAnti.png");
    private static Icon blueAnti = new ImageIcon("src/resource/blueAnti.png");
    private static Color beforeClickedColor = new Color(255,103,103);
    private static Color afterClickedColor = new Color(225,238,229);

    public HeartCellPanel(){
        setOpaque(true);

        this.setLayout(null);
        this.setBounds(0,220,cellPanelWidth,cellPanelHeight);
        this.setBackground(Color.red);
        this.setLayout(new GridLayout(Organ.getM(),Organ.getN()));
        createButtonForFirstRec();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2D = (Graphics2D) g;
    }
    public void createButtonForFirstRec(){
        int index = 0;
        for(int i=0;i<Organ.getM();i++){
            for (int j = 0; j < Organ.getN(); j++) {
                CellButton button = new CellButton();
                button.setFont(new Font("Roboto Condensed",Font.PLAIN,24));
                button.setBackground(beforeClickedColor);
                button.setBorder(BorderFactory.createLineBorder(new Color(151,52,46)));
                button.setX(j);
                button.setY(i);
                button.addActionListener(e ->{
                    int elementIndex = ShopRecPanel.getChoosedElementIndex() - 1;
                    int x = button.getThisX(), y = button.getThisY();
                    Cell cell = organ.coordinate(x,y);
                    if(gameStates == playerAction){
                        //if buy button is clicked.
                        if(ShopRecPanel.getBuyButtonClicked()){
                            if(cell == null){
                                Market.shop(elementIndex,organ,x,y);
                                ShopRecPanel.setBuyButtonClicked(false);
                                MainGame.increaseTimeUnit(1);
                            }
                            else{
                                System.out.println("Can't place here!!!!!");
                            }

                            button.setClicked(false);
                            button.setBackground(beforeClickedColor);
                            CellPanel.wasClicked = false;
                        }
                        //if buy button isn't clicked.
                        else{
                            if(!CellPanel.wasClicked){
                                if(cell instanceof Antibody && cell.getHp() > Antibody.getMoveCost()){
                                    ShopRecPanel.setElementIndex(0);
                                    ShopRecPanel.updateButton();
                                    CellPanel.wasClicked = true;
                                    button.setClicked(true);
                                    button.setBackground(afterClickedColor);
                                    CellPanel.x = x;
                                    CellPanel.y = y;
                                    CellPanel.oldCellIndex = button.getIndexOfThisButton();
                                }
                            }
                            else{
                                if(cell == null){
                                    Antibody anti = (Antibody) organ.coordinate(CellPanel.x,CellPanel.y);
                                    organ.getPosition()[y][x] = organ.getPosition()[CellPanel.y][CellPanel.x];
                                    organ.getPosition()[y][x].decreaseHP(Antibody.getMoveCost());
                                    MainGame.increaseTimeUnit(1);
                                    organ.getPosition()[CellPanel.y][CellPanel.x] = null;
                                    CellPanel.wasClicked = false;
                                    buttons.get(CellPanel.oldCellIndex).setClicked(false);
                                }
                            }
                        }
                    }
                });
                buttons.add(button);
                this.add(button);
                button.setIndexOfThisButton(index);
                index++;
            }
        }
    }
    public static void updateButton(){
        int count = 0;
        for(int i = 0;i < Organ.getM();i++){
            for(int j = 0;j < Organ.getN();j++){
                Cell cell = organ.coordinate(buttons.get(count).getThisX(),buttons.get(count).getThisY());
                CellButton button = buttons.get(count);
                if( cell instanceof Virus){
                    if(cell.getType().equals("fire")){
                        button.setIcon(redVirus);
                    }
                    else if(cell.getType().equals("water")){
                        button.setIcon(blueVirus);
                    }
                    else if(cell.getType().equals("grass")){
                        button.setIcon(greenVirus);
                    }
                    button.setText(String.valueOf(cell.getHp()));

                }
                else if( organ.coordinate(buttons.get(count).getThisX(),buttons.get(count).getThisY()) instanceof Antibody){
                    if(cell.getType().equals("fire")){
                        button.setIcon(redAnti);
                    }
                    else if(cell.getType().equals("water")){
                        button.setIcon(blueAnti);
                    }
                    else if(cell.getType().equals("grass")){
                        button.setIcon(greenAnti);
                    }
                    button.setText(String.valueOf(cell.getHp()));
                }
                else{
                    button.setIcon(null);
                    buttons.get(count).setText("");
                }
                if(!button.getClicked()){
                    button.setBackground(beforeClickedColor);
                }
                if(!CellPanel.wasClicked){
                    button.setBackground(beforeClickedColor);
                }
                count++;
            }
        }
    }

}
