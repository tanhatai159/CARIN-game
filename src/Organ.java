import java.util.Random;

public class Organ {
    int m,n;
    Random rand = new Random();
    Cell[][] position = new Cell[100][100];
    public Cell coor(int x, int y){
        return position[y][x];
    }
    public void generateVirus(int x, int y){
        int type = rand.nextInt(3);
        if(position[y][x] == null){
            position[y][x] = new Virus(this, type);
        }
    }
}
