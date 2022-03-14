package MainClass;

import Human.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backend {
    private static int timeUnit = 0;
    private int state = 1, amountOfOrgan = 1;
    private boolean gameStart = false;
    private boolean gameEnd = false;
    private Body body;
    private GameStates gameStates = GameStates.gameStates;

    public static int getTimeUnit(){
        return timeUnit;
    }
    public static void setTimeUnit(int n){
        timeUnit = n;
    }
    public static void increaseTimeUnit(int amount){
        timeUnit += amount;
    }

    public void gameLoop(){
        switch (gameStates) {
            case menu -> System.out.print("");
            case generateVirus -> System.out.print("1");
            case playerAction -> System.out.print("2");
            case cellAction -> System.out.print("3");
            case end -> System.out.println("4");
        }
    }

}
