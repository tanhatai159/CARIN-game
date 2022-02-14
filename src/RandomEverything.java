import java.util.Random;

public class RandomEverything {
    static Random rand;

    public static Random useRandom(){
        if(rand == null){
            rand = new Random();
        }
        return rand;
    }

}
