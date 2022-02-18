package MainClass;

public class MainGame {
    private static int timeUnit = 0;

    public static int getTimeUnit(){
        return timeUnit;
    }
    public static void setTimeUnit(int n){
        timeUnit = n;
    }
    public static void increaseTimeUnit(int amount){
        timeUnit += amount;
    }
}
