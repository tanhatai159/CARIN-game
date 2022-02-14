public class Antibody extends Cell {
    int HP;
    static int placementCost, atk, startHP, hpGain, moveCost,amountOfAntibody = 0;
    Virus attackByThisVirus; //to tell which current virus attack this antibody and to use when this antibody dead.
    public Antibody(Organ organ,int typeNumber,int x, int y){
        this.x = x;
        this.y = y;
        this.currentOrgan = organ;
        this.type = element[typeNumber];
        this.HP = Antibody.startHP;
        amountOfAntibody++;
    }
    public static void update(int atk, int HP, int moveCost,int placementCost ,int hpGain){
        Antibody.atk = atk;
        Antibody.startHP = HP;
        Antibody.moveCost = moveCost;
        Antibody.placementCost = placementCost;
        Antibody.hpGain = hpGain;
    }
}
