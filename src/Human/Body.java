package Human;

import java.util.ArrayList;

public class Body {
    private ArrayList<Organ> AllOrgan;

    public Body(int amount){
        AllOrgan = new ArrayList<>();
        for(int i = 0;i < amount;i++){
            AllOrgan.add(new Organ());
        }
    }

    public ArrayList<Organ> getAllOrgan(){
        return AllOrgan;
    }

}
