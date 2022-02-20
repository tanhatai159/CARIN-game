package Human;

import Node.ProgramNode;
import Parser.Parser;

import java.util.ArrayList;
import java.util.HashMap;

import static Human.Organ.n;
import static Human.Organ.m;
import static MainClass.Player.increaseCredit;

public class Cell {
    protected static ArrayList<String> elementList = null; //grass <-- fire <-- water <-- grass
    protected final String[] Direction = {"left", "right", "up","down","upleft","upright","downleft","downright",};
    String type, geneticPath; // type of each cell
    Organ currentOrgan; // เพื่อบอกว่า cell ตัวนี้อยู่ที่ organ ไหน
    int x, y;
    int hp,dmg;
    ProgramNode genetic;
    Parser p;

    public void readGenetic_Code(){
        if(p == null || genetic == null){
            p = new Parser("Genetic_Code/Genetic_Code.txt");
            genetic = p.Parse();
        }
        genetic.eval(this,new HashMap<String,Integer>());
    }

    public void move(String direction){
        int xOld = x;
        int yOld = y;
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
        if(x < 0) x = 0;
        if(x > n-1) x = n-1;
        if(y < 0) y = 0;
        if(y > m-1) y = m-1;
        if(currentOrgan.coordinate(x,y) == null){
            currentOrgan.position[yOld][xOld] = null;
            currentOrgan.position[y][x] = this;
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
        if(xEnemy < 0) xEnemy = 0;
        if(xEnemy > n-1) xEnemy = n-1;
        if(yEnemy < 0) yEnemy = 0;
        if(yEnemy > m-1) yEnemy = m-1;
        Cell enemy = currentOrgan.coordinate(xEnemy,yEnemy);
        if(this instanceof Virus) {
            if (enemy instanceof Antibody) {
                ((Antibody) enemy).attackByThisVirus = (Virus) this;
                if ((this.type.equals("fire") && enemy.type.equals("grass")) || (this.type.equals("water") && enemy.type.equals("fire")) || (this.type.equals("grass") && enemy.type.equals("water"))) {
                    enemy.hp = enemy.hp - (this.dmg * 2);
                } else enemy.hp = enemy.hp - this.dmg;
                if (enemy.hp < 1) {
                    enemy.hp = 0;
                }
                if (enemy.hp == 0) {
                    ((Antibody) enemy).mutation();
                    Antibody.amountOfAntibody--;
                }
            }
        }
        if(this instanceof Antibody) {
            if (enemy instanceof Virus) {
                if ((this.type.equals("fire") && enemy.type.equals("grass")) || (this.type.equals("water") && enemy.type.equals("fire")) || (this.type.equals("grass") && enemy.type.equals("water"))) {
                    enemy.hp = enemy.hp - (this.dmg * 2);
                } else enemy.hp = enemy.hp - this.dmg;
                if (enemy.hp < 1) {
                    enemy.hp = 0;
                }
                if (enemy.hp == 0) {
                    currentOrgan.position[yEnemy][xEnemy] = null;
                    Virus.amountOfVirus--;
                    increaseCredit(100);
                }
            }
        }
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
        Cell target = null ;

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
            if ((xTarget <0 || yTarget<0)||(xTarget>n-1 || yTarget>n-1)){
                break;
        }
            target = currentOrgan.coordinate(xTarget,yTarget); // update target

        }while (distance<range && target == null && xTarget <= n && yTarget <= m );

        if (target instanceof Virus) {
            return (10*distance)+1;
        }else if (target instanceof Antibody){
            return (10*distance)+2;
        }else return  0;
    }

    public static void update(){
        elementList = new ArrayList<>();
        elementList.add("fire");
        elementList.add("water");
        elementList.add("grass");
    }
}
