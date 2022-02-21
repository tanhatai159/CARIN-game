package Human;

import MainClass.MainGame;

public class Virus extends Cell {
//    int HP;
    static int amountOfVirus = 0, atk, startHP, hpGain;
    public Virus(Organ organ, int type, int x, int y, String geneticPath, boolean isNewCellQ){
        this.x = x;
        this.y = y;
        this.currentOrgan = organ;
        this.hp = startHP;
        this.type = elementList.get(type);
        this.geneticPath = geneticPath;
        amountOfVirus++;
        if(!isNewCellQ){
            Body.getCellQueue().add(this);
        }
        else{
            Body.getCellQueueNew().add(this);
        }
    }
    public static void update(int atk, int HP, int hpGain) {
        Virus.atk = atk;
        Virus.startHP = HP;
        Virus.hpGain = hpGain;
    }
    public static int getAmountOfVirus(){
        return amountOfVirus;
    }
}
