package MainClass;

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
        if(enemyHP<1) { enemyHP = 0;}


    }

//    public int virusScan(){}
//    public int antibodyScan(){}

    public int nearby(String direction){
        int range = 3, distance = 0;
        Cell target;
        int xTarget = x, yTarget = y;

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

        }while (distance<range && target == null);

        if (target instanceof Virus) {
            return (10*distance)+1;
        }else if (target instanceof Antibody){
            return (10*distance)+2;
        }else return  0;
    }

}
