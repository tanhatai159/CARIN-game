public class Virus extends Cell {
    int atk, HP, hpGain;
    static int amountOfVirus = 0;
    public Virus(Organ organ, int type){
        this.organ = organ;
        this.type = this.element[type];
        amountOfVirus++;
    }
    public void update(int atk, int HP, int hpGain) {
        this.atk = atk;
        this.HP = HP;
        this.hpGain = hpGain;
    }
}
