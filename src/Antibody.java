public class Antibody extends Cell {
    int atk, HP, moveCost, hpGain;
    static int placementCost;
    static int amountOfAntibody = 0;
    Virus attackByThisVirus; //to tell which current virus attack this antibody and to use when this antibody dead.
    public Antibody(Organ organ,int typeNumber){
        this.organ = organ;
        this.type = element[typeNumber];
        amountOfAntibody++;
    }
    public void update(int atk, int HP, int moveCost,int placementCost ,int hpGain){
        this.atk = atk;
        this.HP = HP;
        this.moveCost = moveCost;
        Antibody.placementCost = placementCost;
        this.hpGain = hpGain;
    }
}
