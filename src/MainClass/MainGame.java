package MainClass;

import java.util.LinkedList;
import java.util.Queue;

public class MainGame extends Thread {
    private static int timeUnit = 0;
    private int state = 1;
    private boolean gameStart = false, gameEnd = false;
    private Body body;
    static Queue<Cell> cellQueue;
    public static int getTimeUnit(){
        return timeUnit;
    }
    public static void setTimeUnit(int n){
        timeUnit = n;
    }
    public static void increaseTimeUnit(int amount){
        timeUnit += amount;
    }

    @Override
    public void run(){

    }

    public void gameLoop() throws Exception {
        if(state == 1){
            ReadConfig.readConfig("config.txt");
            body = new Body();
            cellQueue = new LinkedList<>();
        }
        else if(state == 2){

        }
        else if(state == 3){

        }
        else if(state == 4){

        }
        else if(state == 5){

        }
    }
}
