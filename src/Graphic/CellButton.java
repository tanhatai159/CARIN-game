package Graphic;

import javax.swing.*;

public class CellButton extends JButton {
    private boolean isEmpty = true;
    private boolean isAntibody = false;
    private boolean isVirus = false;
    private int x, y;

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
}
