package Human;

import java.util.ArrayList;

public class Body {
    private ArrayList<Organ> AllOrgan;

    public Body(){
        for(int i = 0;i < 3;i++){
            AllOrgan.add(new Organ());
        }
    }

    public ArrayList<Organ> getAllOrgan(){
        return AllOrgan;
    }

}
