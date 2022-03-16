package MainClass;

import Graphic.MainFrame;
import Human.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import static MainClass.GameStates.*;

public class MainGame {
    private static int timeUnit = 0;
    private int state = 1, amountOfOrgan = 1;
    private boolean gameStart = false;
    private boolean gameEnd = false;
    private boolean firstTime = false;
    private Body body;
    private MainFrame window;

    public MainGame(){
        try {
            ReadConfig.readConfig("config.txt");
        }catch (Exception e){
        }
        window = new MainFrame();
    }

    public static int getTimeUnit(){
        return timeUnit;
    }
    public static void setTimeUnit(int n){
        timeUnit = n;
    }
    public static void increaseTimeUnit(int amount){
        timeUnit += amount;
    }

    public void gameLoop() throws Exception {
//        if(state == 1){
//            gameState1();
//            increaseTimeUnit(1);
//        }
//        else if(state == 2){
//            gameState2();
//            increaseTimeUnit(1);
//        }
//        else if(state == 3){
//            gameState3();
//        }
//        else if(state == 4){
//            gameState4();
//        }
//        else if(state == 5){
//            gameState5();
//        }

        switch (GameStates.gameStates){
            case menu:
                gameState1();
                break;
            case generateVirus:
                gameState2();
                break;
            case playerAction:
                gameState3();
                break;
            case cellAction:
                gameState4();
                break;
            case end:
                gameState5();
                break;
        }
    }

    private void gameState1() throws Exception {
        if(!firstTime){
            System.out.println("-----------------Start game state-----------------");
            body = new Body(amountOfOrgan);
            firstTime = true;
            Display.render(body);
        }
        window.render();
//        state = 2;
//        GameStates.gameStates = generateVirus;
    }

    private void gameState2(){
        System.out.println("-----------------Generate virus state-----------------");
        for(Organ organ : body.getAllOrgan()){
            organ.generateVirus();
        }
        Display.render(body);
        window.render();
        state = 3;
        GameStates.gameStates = playerAction;
    }

    private void gameState3(){
        System.out.println("-----------------Player action state-----------------");
        boolean playerDone = false, typeSomething = false;
        String command = "";
        int indexOfOrgan = 0, indexOfType = 0, x, y;
        while (!playerDone){
            System.out.print("Type Command: ");
            Scanner s = new Scanner(System.in);
            command = s.nextLine();
            String[] arr = command.split(" ");// command(buy) indexOfOrgan(1|2|3) type(1|2|3) x y
            try{
                if(arr[0].equalsIgnoreCase("buy")){
                    if(arr[1] != null && arr[2] != null && arr[3] != null && arr[4] != null){
                        indexOfOrgan = Integer.parseInt(arr[1]);
                        indexOfType = Integer.parseInt(arr[2]);
                        x = Integer.parseInt(arr[3]);
                        y = Integer.parseInt(arr[4]);
                        if((indexOfOrgan <= amountOfOrgan && indexOfOrgan > 0) && (indexOfType <= 3 && indexOfType > 0) && (x < Organ.getN() && x >= 0) && (y < Organ.getM() && y >= 0)){
                            Market.shop(indexOfType-1,body.getAllOrgan().get(indexOfOrgan-1),x,y);
                            if(Antibody.getAmountOfAntibody() > 0 && Virus.getAmountOfVirus() > 0){
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
                else if(arr[0].equalsIgnoreCase("done")){
                    playerDone = true;
                }
                else{
                    throw new Exception("Command is not correct!!!!!!!!!!!!!!!!");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            increaseTimeUnit(1);
            Display.render(body);
            window.render();
        }
        state = 4;
        gameStates = cellAction;
        Display.render(body);
        window.render();
    }

    private void gameState4() throws Exception {
        System.out.println("-----------------Cell action state-----------------");
        Queue<Cell> surviveCell = new LinkedList<>();
        Body.getCellQueueNew().clear();

        for(Cell cell : Body.getCellQueue()){
            if(cell.getHp() > 0){
                cell.readGenetic_Code();
            }
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            Display.render(body);
            window.render();
        }
        //find cell that survive
        for(Cell cell : Body.getCellQueue()){
            if(cell.getHp() > 0){
                surviveCell.add(cell);
            }
        }

        Body.getCellQueue().clear();
        Body.getCellQueue().addAll(surviveCell);
        Body.getCellQueue().addAll(Body.getCellQueueNew());

        if((Antibody.getAmountOfAntibody() == 0 || Virus.getAmountOfVirus() == 0) && gameStart){
            state = 5;
            gameStates = end;
        }
        else{
            state = 2;
            gameStates = generateVirus;
        }
    }

    private void gameState5(){
        gameEnd = true;
        if(Antibody.getAmountOfAntibody() > 0){
            System.out.println("Antibody win!!!!!!!!!!!!!");
        }
        else{
            System.out.println("Virus win!!!!!!!!!!!!!!!!");
        }
    }

    private void moveByPlayer(){

    }

    public static void main(String[] args) throws Exception {
        MainGame game = new MainGame();
        while (!game.gameEnd){
            game.gameLoop();
        }
    }
}
