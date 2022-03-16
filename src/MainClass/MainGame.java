package MainClass;

import Graphic.MainFrame;
import Human.*;

import java.util.LinkedList;
import java.util.Queue;

import static MainClass.GameStates.*;

public class MainGame {
    private static int timeUnit = 0;
    private int state = 1, amountOfOrgan = 3;
    private boolean gameStart = false;
    private boolean gameEnd = false;
    private boolean firstTime = false;
    private static boolean playerWin = false;
    private Body body;
    private MainFrame window;

    public MainGame(){
        try {
            ReadConfig.readConfig("config.txt");
        }catch (Exception e){
        }
        body = new Body(amountOfOrgan);
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

    private void gameState1() {
        if(!firstTime){
            System.out.println("-----------------Start game state-----------------");
            firstTime = true;
            playerWin = false;
            Display.render(body);
        }
        window.render();
    }

    private void gameState2(){
        System.out.println("-----------------Generate virus state-----------------");
        for(Organ organ : Body.getAllOrgan()){
            organ.generateVirus();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            window.render();
        }
        Display.render(body);
        window.render();
        state = 3;
        GameStates.gameStates = playerAction;
    }

    private void gameState3(){
        if(Antibody.getAmountOfAntibody() > 0 && Virus.getAmountOfVirus() > 0){
            gameStart = true;
        }
        window.render();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }

    private void gameState4() throws Exception {
        System.out.println("-----------------Cell action state-----------------");
        Queue<Cell> surviveCell = new LinkedList<>();
        Body.getCellQueueNew().clear();

        for(Cell cell : Body.getCellQueue()){
            if(cell.getHp() > 0){
                cell.readGenetic_Code();
            }
            window.render();
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            Display.render(body);
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
            playerWin = true;
        }
        else{
            System.out.println("Virus win!!!!!!!!!!!!!!!!");
        }
        window.render();
    }

    private void moveByPlayer(){

    }

    public static void main(String[] args) throws Exception {
        MainGame game = new MainGame();
        game.play();

    }

    public static boolean getPlayerWin(){
        return playerWin;
    }

    public void play(){
        while (!gameEnd){
            try {
                gameLoop();
            }catch (Exception e){

            }
        }
    }
}
