package MainClass;

import Human.Antibody;
import Human.Organ;

public class Market {

    public static void shop(int type, Organ organ, int x, int y){
        if(organ.getPosition()[y][x] == null){
            if(Player.getCredits() >= Antibody.getPlacementCost()){
                organ.getPosition()[y][x] = new Antibody(organ, type, x,y);
                Player.decreaseCredit(Antibody.getPlacementCost());
            }
            else{
                System.out.println("Don't have enough credits!!!!!!!!!!!!!!!!");
            }
        }
        else{
            System.out.println("Can't place antibody here!!!!!!!!!!!!!");
        }
    }
}
