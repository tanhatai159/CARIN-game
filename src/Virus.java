public class Virus extends Cell {
    int HP;
    static int amountOfVirus = 0, atk, startHP, hpGain;
    public Virus(Organ organ, int type,int x,int y){
        this.x = x;
        this.y = y;
        this.currentOrgan = organ;
        this.HP = startHP;
        this.type = this.element[type];
        amountOfVirus++;
    }
    public static void update(int atk, int HP, int hpGain) {
        Virus.atk = atk;
        Virus.startHP = HP;
        Virus.hpGain = hpGain;
    }
}
