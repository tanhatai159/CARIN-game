import java.util.Random;

public class Organ {
    static int m,n;
    Random rand = new Random();
    Cell[][] position;

    public Organ(){
        position = new Cell[m][n];
    }

    public Cell coordinate(int x, int y){
        return position[y][x];
    }

    public void generateVirus(int x, int y){
        int type = rand.nextInt(3);
        if(position[y][x] == null){
            position[y][x] = new Virus(this, type);
        }
    }

    public static void update(int m, int n){
        Organ.m = m;
        Organ.n = n;
    }
}
