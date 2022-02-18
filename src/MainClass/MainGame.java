package MainClass;

import Human.Body;
import Human.Cell;
import Human.Organ;

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
    public static Queue<Cell> getCellQueue(){
        return cellQueue;
    }

    @Override
    public void run(){

    }

    public void gameLoop() throws Exception {
        if(state == 1){
            try {
                ReadConfig.readConfig("config.txt");
            }catch (Exception e){
                throw new Exception("Can't start game because config file path is not correct.");
            }
            body = new Body();
            cellQueue = new LinkedList<>();
            state = 2;
        }
        else if(state == 2){
            for(Organ organ : body.getAllOrgan()){
                organ.generateVirus();

            }
        }
        else if(state == 3){

        }
        else if(state == 4){

        }
        else if(state == 5){

        }
    }
}
