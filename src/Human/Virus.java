package Human;

import MainClass.MainGame;

public class Virus extends Cell {
//    int HP;
    static int amountOfVirus = 0, atk, VirusStartHP, VirusHpGain;
    public Virus(Organ organ, int type, int x, int y, String geneticPath, boolean isNewCellQ){
        this.x = x;
        this.y = y;
        this.currentOrgan = organ;
        this.hp = VirusStartHP;
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
        Virus.VirusStartHP = HP;
        Virus.VirusHpGain = hpGain;
    }
    public static int getAmountOfVirus(){
        return amountOfVirus;
    }
}
