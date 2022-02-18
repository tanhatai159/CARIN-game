package MainClass;

import Human.Antibody;
import Human.Organ;

public class Market {

    public static void shop(int type, Organ organ, int x, int y){
        organ.getPosition()[y][x] = new Antibody(organ, type, x,y);
    }
}
