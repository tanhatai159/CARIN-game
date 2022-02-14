public class Player {
    int credits;
    static int initialCredits, time = 0;

    public static void update(int credits){
        Player.initialCredits = credits;
    }
}
