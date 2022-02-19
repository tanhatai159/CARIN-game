package Human;

import MainClass.RandomEverything;

public class Organ {
    static int m,n;
    static double rate;
    private boolean isPossible = false;
    Cell[][] position;

    public Organ(){
        position = new Cell[m][n];
    }

    public Cell coordinate(int x, int y){
        return position[y][x];
    }

    public void generateVirus(){
        isPossible = false;
        int number = RandomEverything.useRandom().nextInt(100);
        if(number <= rate*100){
            isPossible = true;
        }
        if(isPossible){
            int type = RandomEverything.useRandom().nextInt(3);
            int x = RandomEverything.useRandom().nextInt(n);
            int y = RandomEverything.useRandom().nextInt(m);
            if(position[y][x] == null){
                position[y][x] = new Virus(this, type,x,y, "Genetic_Code.txt");
            }
        }
    }

    public Cell[][] getPosition(){
        return position;
    }

    public static void update(int m, int n, double rate){
        Organ.m = m;
        Organ.n = n;
        Organ.rate = rate;
    }

    public static int getM(){
        return m;
    }

    public static int getN(){
        return n;
    }
}
