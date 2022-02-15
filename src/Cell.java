import java.util.Objects;

public class Cell {
    protected final String[] element = {"fire", "water", "grass"}; //grass <-- fire <-- water <-- grass
    String type; // type of each cell
    Organ currentOrgan; // เพื่อบอกว่า cell ตัวนี้อยู่ที่ organ ไหน
    int x, y;
    int hp,dmg;

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
    }

//    public int virusScan(){}
//    public int antibodyScan(){}
//    public int nearby(){}

}
