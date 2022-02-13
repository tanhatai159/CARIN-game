import java.util.Random;

public class Organ {
    int m,n;
    Random rand = new Random();
    Cell[][] position;

    public Cell coor(int x, int y){
        return position[y][x];
    }

    public void generateVirus(int x, int y){
        int type = rand.nextInt(3);
        if(position[y][x] == null){
            position[y][x] = new Virus(this, type);
        }
    }

    public void update(int m, int n){
        this.m = m;
        this.n = n;
        position = new Cell[m][n];
    }
}
