package MainClass;

public class Organ {
    static int m,n;
    Cell[][] position;

    public Organ(){
        position = new Cell[m][n];
    }

    public Cell coordinate(int x, int y){
        return position[y][x];
    }

    public void generateVirus(){
        int type = RandomEverything.useRandom().nextInt(3);
        int x = RandomEverything.useRandom().nextInt(n);
        int y = RandomEverything.useRandom().nextInt(m);
        if(position[y][x] == null){
            position[y][x] = new Virus(this, type,x,y);
        }
    }

    public static void update(int m, int n){
        Organ.m = m;
        Organ.n = n;
    }
}
