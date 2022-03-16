package Human;

import MainClass.MainGame;
import MainClass.RandomEverything;

import java.util.Random;

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
        amountOfAntibody++;
        Body.getCellQueue().add(this);

        //random genetic
        int maxBound = GeneticCode.getAmountOfAntibodyGeneticPath();
        Random rand = RandomEverything.useRandom();
        super.geneticPath = GeneticCode.getAntibodyGeneticPath(rand.nextInt(maxBound));
    }
    public static void update(int atk, int HP, int moveCost,int placementCost ,int hpGain){
        Antibody.atk = atk;
        Antibody.AntibodyStartHP = HP;
        Antibody.moveCost = moveCost;
        Antibody.placementCost = placementCost;
        Antibody.AntibodyHpGain = hpGain;
    }
    public void mutation(){
        int typeNumber = elementList.indexOf(attackByThisVirus.type);
        currentOrgan.position[y][x] = new Virus(currentOrgan, typeNumber, x, y, "Genetic_Code/Genetic_Code.txt",true);
        Body.getCellQueueNew().add(currentOrgan.coordinate(x,y));
    }
    public static int getAmountOfAntibody(){
        return amountOfAntibody;
    }

    public static int getPlacementCost(){
        return placementCost;
    }

    public static int getMoveCost(){
        return moveCost;
    }

    public void moveByPlayer(int x ,int y,Organ organ){
        int xOld = this.x;
        int yOld = this.y;
        if(currentOrgan.coordinate(x,y) == null && this.hp > moveCost){
            currentOrgan.position[y][x] = currentOrgan.position[this.y][this.x];
            organ.position[y][x] = organ.position[this.x][this.y];
            currentOrgan.position[this.y][this.x] = null;
            organ.position[this.y][this.x] = null;
            this.hp -= moveCost;
        }
    }
}
