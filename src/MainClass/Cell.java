package MainClass;

import static MainClass.Organ.n;
import static MainClass.Organ.m;

public class Cell {
    protected final String[] element = {"fire", "water", "grass"}; //grass <-- fire <-- water <-- grass
    protected final String[] Direction = {"left", "right", "up","down","upleft","upright","downleft","downright",};
    String type; // type of each cell
    Organ currentOrgan; // เพื่อบอกว่า cell ตัวนี้อยู่ที่ organ ไหน
    int x, y;
    int hp,dmg;

    public void readGenetic_Code(String path){

    }

    public void move(String direction){
        switch (direction) {
            case "left" -> x = x - 1;
            case "right" -> x = x + 1;
            case "up" -> y = y - 1;
            case "down" -> y = y + 1;
            case "upleft" -> {
                x = x - 1;
                y = y - 1;
            }case "upright" -> {
                x = x + 1;
                y = y - 1;
            }case "downleft" -> {
                x = x - 1;
                y = y + 1;
            }case "downright" -> {
                x = x + 1;
                y = y + 1;
            }
        }
    }


    public void shoot(String direction){
        int xEnemy = x, yEnemy = y;
        switch (direction) {
            case "left" -> xEnemy = x - 1;
            case "right" -> xEnemy = x + 1;
            case "up" -> yEnemy = y - 1;
            case "down" -> yEnemy = y + 1;
            case "upleft" -> {
                xEnemy = x - 1;
                yEnemy = y - 1;
            }case "upright" -> {
                xEnemy = x + 1;
                yEnemy = y - 1;
            }case "downleft" -> {
                xEnemy = x - 1;
                yEnemy = y + 1;
            }case "downright" -> {
                xEnemy = x + 1;
                yEnemy = y + 1;
            }
        }
        Cell enemy = currentOrgan.coordinate(xEnemy,yEnemy);
        int enemyHP = enemy.hp;
        if (enemy instanceof Antibody){
            ((Antibody) enemy).attackByThisVirus = (Virus) this;
        }if((this.type.equals("fire") && enemy.type.equals("grass"))||(this.type.equals("water") && enemy.type.equals("fire"))||(this.type.equals("grass") && enemy.type.equals("water"))){
            enemyHP = enemyHP - (this.dmg*2);
        }else enemyHP = enemyHP - this.dmg;
        if(enemyHP<1) { enemyHP = 0;}


    }

    public int scanVirus(){
        int closest = Integer.MAX_VALUE;
        for(int i = 0;i < Direction.length;i++){
            if(nearby(Direction[i]) != 0){
                int findCloset = nearby(Direction[i]);
                if(findCloset< closest){
                    if((findCloset%10)-1 == 0) closest = findCloset;
                }
            }
        }
        if(closest == Integer.MAX_VALUE) return  0;
        else{
            return closest;
        }
    }
    public int scanAntibody(){
        int closest = Integer.MAX_VALUE;
        for(int i = 0;i < Direction.length;i++){
            if(nearby(Direction[i]) != 0){
                int findCloset = nearby(Direction[i]);
                if(findCloset< closest){
                    if((findCloset%10)-2 == 0) closest = findCloset;
                }
            }
        }
        if(closest == Integer.MAX_VALUE) return  0;
        else{
            return closest;
        }
    }

    public int nearby(String direction){
        int range = 3, distance = 0;
        int xTarget = x, yTarget = y;
        Cell target;


        do{
            distance++; // update distance
        switch (direction) {
            case "left" -> xTarget = x - distance;
            case "right" -> xTarget = x + distance;
            case "up" -> yTarget = y - distance;
            case "down" -> yTarget = y + distance;
            case "upleft" -> {
                xTarget = x - distance;
                yTarget = y - distance;
            }case "upright" -> {
                xTarget = x + distance;
                yTarget = y - distance;
            }case "downleft" -> {
                xTarget = x - distance;
                yTarget = y + distance;
            }case "downright" -> {
                xTarget = x + distance;
                yTarget = y + distance;
            }
        }
            target = currentOrgan.coordinate(xTarget,yTarget); // update target

        }while (distance<range && target == null && x < n && y < m);

        if (target instanceof Virus) {
            return (10*distance)+1;
        }else if (target instanceof Antibody){
            return (10*distance)+2;
        }else return  0;
    }

}