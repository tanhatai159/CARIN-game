package MainClass;

import Human.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainGame {
    private static int timeUnit = 0;
    private int state = 1, amountOfOrgan = 1;
    private boolean gameStart = false;
    private boolean gameEnd = false;
    private Body body;
    static Queue<Cell> cellQueue = new LinkedList<>();
    private Scanner s;

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

//    @Override
//    public void run(){
//        while (!gameEnd){
//            try {
//                gameLoop();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public void gameLoop() throws Exception {
        if(state == 1){
            System.out.println("-----------------Start game state-----------------");
            try {
                ReadConfig.readConfig("config.txt");
            }catch (Exception e){
                throw new Exception("Can't start game because config file path is not correct.");
            }
            body = new Body(amountOfOrgan);
            cellQueue = new LinkedList<>();
            state = 2;
            Display.render(body);
        }
        else if(state == 2){
            System.out.println("-----------------Generate virus state-----------------");
            for(Organ organ : body.getAllOrgan()){
                organ.generateVirus();
            }
            Display.render(body);
            state = 3;
        }
        else if(state == 3){
            System.out.println("-----------------Player action state-----------------");
            boolean playerDone = false;
            int indexOfOrgan = 0, indexOfType = 0, x, y;
            while (!playerDone){
                System.out.print("Type Command: ");
                s = new Scanner(System.in);
                String[] arr = s.toString().split(" ");// command(buy) indexOfOrgan(1|2|3) type(1|2|3) x y
                try{
                    if(arr[0].equals("buy")){
                        if(arr[1] != null && arr[2] != null && arr[3] != null && arr[4] != null){
                            indexOfOrgan = Integer.parseInt(arr[1]);
                            indexOfType = Integer.parseInt(arr[2]);
                            x = Integer.parseInt(arr[3]);
                            y = Integer.parseInt(arr[4]);
                            if((indexOfOrgan <= amountOfOrgan && indexOfOrgan > 0) && (indexOfType <= 3 && indexOfType > 0) && (x < Organ.getN() && x >= 0) && (y < Organ.getM() && y >= 0)){
                                Market.shop(indexOfType-1,body.getAllOrgan().get(indexOfOrgan-1),x,y);
                                if(Antibody.getAmountOfAntibody() > 0){
                                    gameStart = true;
                                }
                            }
                            else{
                                throw new Exception("Command is not correct!!!!!!!!!!!!!!!!");
                            }
                        }
                        else{
                            throw new Exception("Command is not correct!!!!!!!!!!!!!!!!");
                        }
                    }
                    else if(arr[0].equals("done")){
                        playerDone = true;
                    }
                    else{
                        throw new Exception("Command is not correct!!!!!!!!!!!!!!!!");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                Display.render(body);
            }
            state = 4;
            Display.render(body);
        }
        else if(state == 4){
            System.out.println("-----------------Cell action state-----------------");
            for(Cell cell : cellQueue){
                cell.readGenetic_Code();
                Display.render(body);
            }
            if((Antibody.getAmountOfAntibody() == 0 || Virus.getAmountOfVirus() == 0) && gameStart){
                state = 5;
            }
            else{
                state = 2;
            }
        }
        else if(state == 5){
            gameEnd = true;
            if(Antibody.getAmountOfAntibody() > 0){
                System.out.println("Antibody win!!!!!!!!!!!!!");
            }
            else{
                System.out.println("Virus win!!!!!!!!!!!!!!!!");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MainGame game = new MainGame();
        while (!game.gameEnd){
            game.gameLoop();
        }
    }
}
