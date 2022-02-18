package MainClass;

import java.util.ArrayList;

public class Body {
    static ArrayList<Organ> AllOrgan;

    public static void update(){
        for(int i = 0;i < 3;i++){
            AllOrgan.add(new Organ());
        }
    }
}
