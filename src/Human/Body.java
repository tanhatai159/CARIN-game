package Human;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Body {
    private static ArrayList<Organ> AllOrgan;
    public static Queue<Cell> cellQueue = new LinkedList<>(), cellQueueNew = new LinkedList<>();

    public Body(int amount){
        AllOrgan = new ArrayList<>();
        for(int i = 0;i < amount;i++){
            AllOrgan.add(new Organ());
        }
    }

    public static ArrayList<Organ> getAllOrgan(){
        return AllOrgan;
    }

    public static Queue<Cell> getCellQueue(){
        return cellQueue;
    }

    public static Queue<Cell> getCellQueueNew(){
        return cellQueueNew;
    }

}
