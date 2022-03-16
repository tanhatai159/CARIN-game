package Graphic;

import javax.swing.*;

public class CellButton extends JButton {
    private boolean isEmpty = true;
    private boolean isAntibody = false;
    private boolean isVirus = false;
    private boolean clicked = false;
    private int x, y;
    private int indexOfThisButton;

    public void setX(int x){
        this.x = x;
    }

    public int getThisX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getThisY(){
        return y;
    }

    public boolean getClicked(){
        return clicked;
    }

    public void setClicked(boolean status){
        clicked = status;
    }

    public int getIndexOfThisButton(){
        return indexOfThisButton;
    }

    public void setIndexOfThisButton(int index){
        indexOfThisButton = index;
    }
}
