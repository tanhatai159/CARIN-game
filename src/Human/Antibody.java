package Human;

import MainClass.MainGame;

public class Antibody extends Cell {
//    int HP;
    static int placementCost, atk, AntibodyStartHP, AntibodyHpGain, moveCost,amountOfAntibody = 0;
    Virus attackByThisVirus; //to tell which current virus attack this antibody and to use when this antibody dead.
    public Antibody(Organ organ, int typeNumber, int x, int y){
        this.x = x;
        this.y = y;
        this.currentOrgan = organ;
        this.type = elementList.get(typeNumber);
        this.hp = Antibody.AntibodyStartHP;
        this.geneticPath = "Genetic_Code.txt";
        amountOfAntibody++;
        Body.getCellQueue().add(this);
    }
    public static void update(int atk, int HP, int moveCost,int placementCost ,int hpGain){
        Antibody.atk = atk;
        Antibody.AntibodyStartHP = HP;
        Antibody.moveCost = moveCost;
        Antibody.placementCost = placementCost;
        Antibody.AntibodyHpGain = hpGain;
    }
    public void mutation(){
        int typeNumber = elementList.indexOf(type);
        currentOrgan.position[y][x] = new Virus(currentOrgan, typeNumber, x, y, "Genetic_Code/Genetic_Code.txt",true);
        Body.getCellQueueNew().add(currentOrgan.coordinate(x,y));
    }
    public static int getAmountOfAntibody(){
        return amountOfAntibody;
    }

    public static int getPlacementCost(){
        return placementCost;
    }
}
