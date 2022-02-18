package MainClass;

public class Player {
    private static int credits;

    public static void update(int credits){
        Player.credits = credits;
    }

    public static int getCredits() {
        return credits;
    }

    public static void increaseCredit(int amount){
        credits += amount;
    }

    public static void decreaseCredit(int amount){
        credits -= amount;
    }
}
